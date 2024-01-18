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

    public int[][][] propagate() {
        int [][][] children;
        int xLow = variables[0][0];
        int xHigh = variables[0][1];
        int yLow = variables[1][0];
        int yHigh = variables[1][1];
        int zLow = variables[2][0];
        int zHigh = variables[2][1];
        if (xLow == xHigh && yLow == yHigh) {
            int zMid = zLow + (zHigh - zLow) / 2;
            int zMid2 = zMid + 1;
            if (zMid == zHigh) {
                zMid2--;
            }
            children = new int[2][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xHigh;
            children[0][1][0] = yLow;
            children[0][1][1] = yHigh;
            children[0][2][0] = zLow;
            children[0][2][1] = zMid;
            children[1][0][0] = xLow;
            children[1][0][1] = xHigh;
            children[1][1][0] = yLow;
            children[1][1][1] = yHigh;
            children[1][2][0] = zMid2;
            children[1][2][1] = zHigh;
        } else if (xLow == xHigh && zLow == zHigh) {
            int yMid = yLow + (yHigh - yLow) / 2;
            int yMid2 = yMid + 1;
            if (yMid == yHigh) {
                yMid2--;
            }
            children = new int[2][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xHigh;
            children[0][1][0] = yLow;
            children[0][1][1] = yMid;
            children[0][2][0] = zLow;
            children[0][2][1] = zHigh;
            children[1][0][0] = xLow;
            children[1][0][1] = xHigh;
            children[1][1][0] = yMid2;
            children[1][1][1] = yHigh;
            children[1][2][0] = zLow;
            children[1][2][1] = zHigh;
        } else if (yLow == yHigh && zLow == zHigh) {
            int xMid = xLow + (xHigh - xLow) / 2;
            int xMid2 = xMid + 1;
            if (xMid == xHigh) {
                xMid2--;
            }
            children = new int[2][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xMid;
            children[0][1][0] = yLow;
            children[0][1][1] = yHigh;
            children[0][2][0] = zLow;
            children[0][2][1] = zHigh;
            children[1][0][0] = xMid2;
            children[1][0][1] = xHigh;
            children[1][1][0] = yLow;
            children[1][1][1] = yHigh;
            children[1][2][0] = zLow;
            children[1][2][1] = zHigh;
        } else if (xLow == xHigh) {
            int yMid = yLow + (yHigh - yLow) / 2;
            int yMid2 = yMid + 1;
            if (yMid == yHigh) {
                yMid2--;
            }
            int zMid = zLow + (zHigh - zLow) / 2;
            int zMid2 = zMid + 1;
            if (zMid == zHigh) {
                zMid2--;
            }
            children = new int[4][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xHigh;
            children[0][1][0] = yLow;
            children[0][1][1] = yMid;
            children[0][2][0] = zLow;
            children[0][2][1] = zMid;
            children[1][0][0] = xLow;
            children[1][0][1] = xHigh;
            children[1][1][0] = yMid2;
            children[1][1][1] = yHigh;
            children[1][2][0] = zLow;
            children[1][2][1] = zMid;
            children[2][0][0] = xLow;
            children[2][0][1] = xHigh;
            children[2][1][0] = yLow;
            children[2][1][1] = yMid;
            children[2][2][0] = zMid2;
            children[2][2][1] = zHigh;
            children[3][0][0] = xLow;
            children[3][0][1] = xHigh;
            children[3][1][0] = yMid2;
            children[3][1][1] = yHigh;
            children[3][2][0] = zMid2;
            children[3][2][1] = zHigh;
        } else if (yLow == yHigh) {
            int xMid = xLow + (xHigh - xLow) / 2;
            int xMid2 = xMid + 1;
            if (xMid == xHigh) {
                xMid2--;
            }
            int zMid = zLow + (zHigh - zLow) / 2;
            int zMid2 = zMid + 1;
            if (zMid == zHigh) {
                zMid2--;
            }
            children = new int[4][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xMid;
            children[0][1][0] = yLow;
            children[0][1][1] = yHigh;
            children[0][2][0] = zLow;
            children[0][2][1] = zMid;
            children[1][0][0] = xMid2;
            children[1][0][1] = xHigh;
            children[1][1][0] = yLow;
            children[1][1][1] = yHigh;
            children[1][2][0] = zLow;
            children[1][2][1] = zMid;
            children[2][0][0] = xLow;
            children[2][0][1] = xMid;
            children[2][1][0] = yLow;
            children[2][1][1] = yHigh;
            children[2][2][0] = zMid2;
            children[2][2][1] = zHigh;
            children[3][0][0] = xMid2;
            children[3][0][1] = xHigh;
            children[3][1][0] = yLow;
            children[3][1][1] = yHigh;
            children[3][2][0] = zMid2;
            children[3][2][1] = zHigh;
        } else if (zLow == zHigh) {
            int xMid = xLow + (xHigh - xLow) / 2;
            int xMid2 = xMid + 1;
            if (xMid == xHigh) {
                xMid2--;
            }
            int yMid = yLow + (yHigh - yLow) / 2;
            int yMid2 = yMid + 1;
            if (yMid == yHigh) {
                yMid2--;
            }
            children = new int[4][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xMid;
            children[0][1][0] = yLow;
            children[0][1][1] = yMid;
            children[0][2][0] = zLow;
            children[0][2][1] = zHigh;
            children[1][0][0] = xMid2;
            children[1][0][1] = xHigh;
            children[1][1][0] = yLow;
            children[1][1][1] = yMid;
            children[1][2][0] = zLow;
            children[1][2][1] = zHigh;
            children[2][0][0] = xLow;
            children[2][0][1] = xMid;
            children[2][1][0] = yMid2;
            children[2][1][1] = yHigh;
            children[2][2][0] = zLow;
            children[2][2][1] = zHigh;
            children[3][0][0] = xMid2;
            children[3][0][1] = xHigh;
            children[3][1][0] = yMid2;
            children[3][1][1] = yHigh;
            children[3][2][0] = zLow;
            children[3][2][1] = zHigh;
        } else {
            int xMid = xLow + (xHigh - xLow) / 2;
            int xMid2 = xMid + 1;
            if (xMid == xHigh) {
                xMid2--;
            }
            int yMid = yLow + (yHigh - yLow) / 2;
            int yMid2 = yMid + 1;
            if (yMid == yHigh) {
                yMid2--;
            }
            int zMid = zLow + (zHigh - zLow) / 2;
            int zMid2 = zMid + 1;
            if (zMid == zHigh) {
                zMid2--;
            }
            children = new int[8][3][2];
            children[0][0][0] = xLow;
            children[0][0][1] = xMid;
            children[0][1][0] = yLow;
            children[0][1][1] = yMid;
            children[0][2][0] = zLow;
            children[0][2][1] = zMid;
            children[1][0][0] = xMid2;
            children[1][0][1] = xHigh;
            children[1][1][0] = yLow;
            children[1][1][1] = yMid;
            children[1][2][0] = zLow;
            children[1][2][1] = zMid;
            children[2][0][0] = xLow;
            children[2][0][1] = xMid;
            children[2][1][0] = yMid2;
            children[2][1][1] = yHigh;
            children[2][2][0] = zLow;
            children[2][2][1] = zMid;
            children[3][0][0] = xLow;
            children[3][0][1] = xMid;
            children[3][1][0] = yLow;
            children[3][1][1] = yMid;
            children[3][2][0] = zMid2;
            children[3][2][1] = zHigh;
            children[4][0][0] = xMid2;
            children[4][0][1] = xHigh;
            children[4][1][0] = yMid2;
            children[4][1][1] = yHigh;
            children[4][2][0] = zLow;
            children[4][2][1] = zMid;
            children[5][0][0] = xMid2;
            children[5][0][1] = xHigh;
            children[5][1][0] = yLow;
            children[5][1][1] = yMid;
            children[5][2][0] = zMid2;
            children[5][2][1] = zHigh;
            children[6][0][0] = xLow;
            children[6][0][1] = xMid;
            children[6][1][0] = yMid2;
            children[6][1][1] = yHigh;
            children[6][2][0] = zMid2;
            children[6][2][1] = zHigh;
            children[7][0][0] = xMid2;
            children[7][0][1] = xHigh;
            children[7][1][0] = yMid2;
            children[7][1][1] = yHigh;
            children[7][2][0] = zMid2;
            children[7][2][1] = zHigh;

        }
        return children;
    }

    public int[][] getCorners() {
        int[][] corners = new int[8][3];
        corners[0][0] = variables[0][0];
        corners[0][1] = variables[1][0];
        corners[0][2] = variables[2][0];
        corners[1][0] = variables[0][1];
        corners[1][1] = variables[1][0];
        corners[1][2] = variables[2][0];
        corners[2][0] = variables[0][0];
        corners[2][1] = variables[1][1];
        corners[2][2] = variables[2][0];
        corners[3][0] = variables[0][0];
        corners[3][1] = variables[1][0];
        corners[3][2] = variables[2][1];
        corners[4][0] = variables[0][1];
        corners[4][1] = variables[1][1];
        corners[4][2] = variables[2][0];
        corners[5][0] = variables[0][0];
        corners[5][1] = variables[1][1];
        corners[5][2] = variables[2][1];
        corners[6][0] = variables[0][1];
        corners[6][1] = variables[1][0];
        corners[6][2] = variables[2][1];
        corners[7][0] = variables[0][1];
        corners[7][1] = variables[1][1];
        corners[7][2] = variables[2][1];
        return corners;

    }

    public String toString() {
        String result = "x: " + variables[0][0] + ", " + variables[0][1] + "\ny: " + variables[1][0] + ", " +
                variables[1][1] + "\nz: " + variables[2][0] + ", " + variables[2][1] + "\nnode: " + closestNode + "\n";
        return result;
    }

}