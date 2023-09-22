package VoronoiTree;

import java.util.ArrayList;

public class Tree {

    private Tree parent;
    private ArrayList<Tree> children;
    private int numDimensions;
    private int[][] variables;
    private boolean isLeaf;
    private int closestNode;
    private boolean[] flat;
    private ArrayList<int[][]> childVarList;
    private int numCorners;
    private ArrayList<int[]> corners;

    public Tree(int[][] vars, Tree parent) {
        variables = new int[vars.length][2];
        for (int i = 0; i < vars.length; i++) {
            variables[i][0] = vars[i][0];
            variables[i][1] = vars[i][1];
        }
        this.parent = parent;
        numDimensions = calcDimensions();
        closestNode = -1;
        isLeaf = false;
        children = new ArrayList<Tree>();
        numCorners = (int)Math.pow(2, variables.length);
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
        populateChildList(listBuilder, 0);
        for (int[][] c : childVarList) {
            children.add(new Tree(c, this));
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
        int[] b = new int[variables.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = list[i];
        }
        if (depth == variables.length) {
            corners.add(b);
            return;
        }
        else {
            b[depth] = variables[depth][0];
            findCorners(b, depth+1);
            b[depth] = variables[depth][1];
            findCorners(b, depth+1);
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