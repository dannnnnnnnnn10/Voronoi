package Voronoi3D;

import java.util.ArrayList;

public class Tree {

    private int[][] variables;
    private int closestNode;

    public Tree(int[][] vars) {
        variables = vars;
        closestNode = -1;
    }

    public void setClosestNode (int node) {
        closestNode = node;
    }

    public ArrayList<Tree> propagate() {
        ArrayList<Tree> children = new ArrayList<Tree>();
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
        children.add(new Tree(new int[][]{new int[]{xLow, xMid}, new int[]{yLow, yMid}, new int[]{zLow, zMid}}));
        children.add(new Tree(new int[][]{new int[]{xMid2, xHigh}, new int[]{yLow, yMid}, new int[]{zLow, zMid}}));
        children.add(new Tree(new int[][]{new int[]{xLow, xMid}, new int[]{yMid2, yHigh}, new int[]{zLow, zMid}}));
        children.add(new Tree(new int[][]{new int[]{xLow, xMid}, new int[]{yLow, yMid}, new int[]{zMid2, zHigh}}));
        children.add(new Tree(new int[][]{new int[]{xMid2, xHigh}, new int[]{yMid2, yHigh}, new int[]{zLow, zMid}}));
        children.add(new Tree(new int[][]{new int[]{xLow, xMid}, new int[]{yMid2, yHigh}, new int[]{zMid2, zHigh}}));
        children.add(new Tree(new int[][]{new int[]{xMid2, xHigh}, new int[]{yLow, yMid}, new int[]{zMid2, zHigh}}));
        children.add(new Tree(new int[][]{new int[]{xMid2, xHigh}, new int[]{yMid2, yHigh}, new int[]{zMid2, zHigh}}));
        return children;
    }

    public ArrayList<int[]> getCorners() {
        ArrayList<int[]> corners = new ArrayList<int[]>();
        corners.add(new int[]{variables[0][0], variables[1][0], variables[2][0]});
        corners.add(new int[]{variables[0][1], variables[1][0], variables[2][0]});
        corners.add(new int[]{variables[0][0], variables[1][1], variables[2][0]});
        corners.add(new int[]{variables[0][0], variables[1][0], variables[2][1]});
        corners.add(new int[]{variables[0][1], variables[1][1], variables[2][0]});
        corners.add(new int[]{variables[0][0], variables[1][1], variables[2][1]});
        corners.add(new int[]{variables[0][1], variables[1][0], variables[2][1]});
        corners.add(new int[]{variables[0][1], variables[1][1], variables[2][1]});
        return corners;

    }

    public String toString() {
        String result = "x: " + variables[0][0] + ", " + variables[0][1] + "\ny: " + variables[1][0] + ", " +
                variables[1][1] + "\nz: " + variables[2][0] + ", " + variables[2][1] + "\nnode: " + closestNode + "\n";
        return result;
    }

}