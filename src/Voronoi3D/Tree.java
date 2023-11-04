package Voronoi3D;

import java.util.ArrayList;

public class Tree {

    private ArrayList<Tree> children;
    private int[][] variables;
    private boolean isLeaf;
    private int closestNode;
    private boolean[] flat;
    private ArrayList<int[][]> childVarList;
    private ArrayList<int[]> corners;

    public Tree(int[][] vars) {
        variables = new int[vars.length][2];
        for (int i = 0; i < vars.length; i++) {
            variables[i][0] = vars[i][0];
            variables[i][1] = vars[i][1];
        }
        closestNode = -1;
        isLeaf = false;
        children = new ArrayList<Tree>();
        corners = new ArrayList<int[]>();
        int[] listBuilder = new int[variables.length];
        findCorners(listBuilder, 0);
    }

    private int calcDimensions() {
        int result = 0;
        flat = new boolean[variables.length];
        for (int i = 0; i < variables.length; i++) {
            flat[i] = (variables[i][0] == variables[i][1]);
        }
        for (boolean b : flat) {
            if (!b) {
                result++;
            }
        }
        return result;
    }

    public void setClosestNode (int node) {
        closestNode = node;
        isLeaf = true;
    }

    public boolean propagate(boolean a) {
        isLeaf = a;
        if (isLeaf) {
            children = null;
        }
        else {
            createChildren();
        }
        return isLeaf;
    }

    private void createChildren() {
        childVarList = new ArrayList<int[][]>();
        int [][] listBuilder = new int[variables.length][2];
        if (variables.length == 3) {
            int xLow = variables[0][0];
            int xHigh = variables[0][1];
            int yLow = variables[1][0];
            int yHigh = variables[1][1];
            int zLow = variables[2][0];
            int zHigh = variables[2][1];
            int xMid = xLow + (xHigh - xLow)/2;
            int xMid2 = xMid+1;
            if (xMid == xHigh) {
                xMid2--;
            }
            int yMid = yLow + (yHigh - yLow)/2;
            int yMid2 = yMid+1;
            if (yMid == yHigh) {
                yMid2--;
            }
            int zMid = zLow + (zHigh - zLow)/2;
            int zMid2 = zMid+1;
            if (zMid == zHigh) {
                zMid2--;
            }
            childVarList.add(new int[][]{new int[]{xLow, xMid}, new int[]{yLow, yMid}, new int[]{zLow, zMid}});
            childVarList.add(new int[][]{new int[]{xMid2, xHigh}, new int[]{yLow, yMid}, new int[]{zLow, zMid}});
            childVarList.add(new int[][]{new int[]{xLow, xMid}, new int[]{yMid2, yHigh}, new int[]{zLow, zMid}});
            childVarList.add(new int[][]{new int[]{xLow, xMid}, new int[]{yLow, yMid}, new int[]{zMid2, zHigh}});
            childVarList.add(new int[][]{new int[]{xMid2, xHigh}, new int[]{yMid2, yHigh}, new int[]{zLow, zMid}});
            childVarList.add(new int[][]{new int[]{xLow, xMid}, new int[]{yMid2, yHigh}, new int[]{zMid2, zHigh}});
            childVarList.add(new int[][]{new int[]{xMid2, xHigh}, new int[]{yLow, yMid}, new int[]{zMid2, zHigh}});
            childVarList.add(new int[][]{new int[]{xMid2, xHigh}, new int[]{yMid2, yHigh}, new int[]{zMid2, zHigh}});
        }
        else {
            calcDimensions();
            populateChildList(listBuilder, 0);
        }
        for (int[][] c : childVarList) {
            children.add(new Tree(c));
        }
    }

    private void populateChildList(int[][] list, int depth) {
        int[][] b = new int[variables.length][2];
        for (int i = 0; i < b.length; i++) {
            b[i][0] = list[i][0];
            b[i][1] = list[i][1];
        }
        if (depth == variables.length) {
            childVarList.add(b);
            return;
        }
        if (flat[depth]) {
            b[depth] = variables[depth];
            populateChildList(b, depth+1);
        }
        else {
            int x1 = variables[depth][0];
            int x2 = variables[depth][1];
            int[] low = new int[2];
            int[] high = new int[2];
            int mid = x1 + (x2 - x1)/2;
            low[0] = x1;
            low[1] = mid;
            high[0] = mid + 1;
            high[1] = x2;
            b[depth] = low;
            populateChildList(b, depth+1);
            b[depth] = high;
            populateChildList(b, depth+1);
        }
    }

    public ArrayList<Tree> getChildren() {
        return children;
    }

    private void findCorners(int[] list, int depth) {
        if (variables.length == 3) {
            corners.add(new int[]{variables[0][0], variables[1][0], variables[2][0]});
            corners.add(new int[]{variables[0][1], variables[1][0], variables[2][0]});
            corners.add(new int[]{variables[0][0], variables[1][1], variables[2][0]});
            corners.add(new int[]{variables[0][0], variables[1][0], variables[2][1]});
            corners.add(new int[]{variables[0][1], variables[1][1], variables[2][0]});
            corners.add(new int[]{variables[0][0], variables[1][1], variables[2][1]});
            corners.add(new int[]{variables[0][1], variables[1][0], variables[2][1]});
            corners.add(new int[]{variables[0][1], variables[1][1], variables[2][1]});
        }
        else {
            findCornersRecursive(list, depth);
        }
    }

    private void findCornersRecursive(int[] list, int depth) {
        int[] b = new int[variables.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = list[i];
        }
        if (depth == variables.length) {
            corners.add(b);
        }
        else {
            b[depth] = variables[depth][0];
            findCornersRecursive(b, depth+1);
            b[depth] = variables[depth][1];
            findCornersRecursive(b, depth+1);
        }
    }

    public ArrayList<int[]> getCorners() {
        return corners;
    }

    public String toString() {
        String result = "";
        if (isLeaf) {
            for (int i = 0; i < variables.length; i++) {
                result += "Dim " + i + ": " + variables[i][0] + ", " + variables[i][1] + "\n";
            }
            result += "Closest Node: " + closestNode + "\n";
        }
        else {
            for (Tree t : children) {
                result += t.toString() + "\n";
            }
        }
        return result;
    }

}