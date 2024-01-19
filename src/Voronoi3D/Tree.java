package Voronoi3D;

import java.util.ArrayList;

public class Tree {

//    private int[][] variables;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int z1;
    private int z2;
    private int closestNode;
    private int[] knownCorners;

    public Tree(int[][] vars) {
        x1 = vars[0][0];
        x2 = vars[0][1];
        y1 = vars[1][0];
        y2 = vars[1][1];
        z1 = vars[2][0];
        z2 = vars[2][1];
//        variables = vars;
        closestNode = -1;
        knownCorners = new int[8];
        for (int i=0; i<8; i++) {
            knownCorners[i] = -1;
        }
    }

    public Tree(int x1, int x2, int y1, int y2, int z1, int z2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
//        variables = vars;
        closestNode = -1;
        knownCorners = new int[8];
        for (int i=0; i<8; i++) {
            knownCorners[i] = -1;
        }
    }

    public Tree(int x1, int x2, int y1, int y2, int z1, int z2, int[] corners) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        closestNode = -1;
        knownCorners = corners;
    }

    public Tree(int[][] vars, int[] corners) {
//        variables = vars;
        x1 = vars[0][0];
        x2 = vars[0][1];
        y1 = vars[1][0];
        y2 = vars[1][1];
        z1 = vars[2][0];
        z2 = vars[2][1];
        closestNode = -1;
        knownCorners = corners;
    }

    public void setClosestNode (int node) {
        closestNode = node;
    }

    public ArrayList<Tree> propagate() {
        int [][][] children;
        ArrayList<Tree> results = new ArrayList<Tree>();
        if (x1 == x2 && y1 == y2) {
            int zMid = z1 + (z2 - z1) / 2;
            int zMid2 = zMid + 1;
            if (zMid == z2) {
                zMid2--;
            }
//            children = new int[2][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = x2;
//            children[0][1][0] = y1;
//            children[0][1][1] = y2;
//            children[0][2][0] = z1;
//            children[0][2][1] = zMid;
//            children[1][0][0] = x1;
//            children[1][0][1] = x2;
//            children[1][1][0] = y1;
//            children[1][1][1] = y2;
//            children[1][2][0] = zMid2;
//            children[1][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], knownCorners[1], knownCorners[2], -1, knownCorners[4], -1, -1, -1};
            int[] corners2 = new int[] {-1, -1, -1, knownCorners[3], -1, knownCorners[5], knownCorners[6], knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, x2, y1, y2, z1, zMid, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(x1, x2, y1, y2, zMid2, z2, corners2));
        } else if (x1 == x2 && z1 == z2) {
            int yMid = y1 + (y2 - y1) / 2;
            int yMid2 = yMid + 1;
            if (yMid == y2) {
                yMid2--;
            }
//            children = new int[2][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = x2;
//            children[0][1][0] = y1;
//            children[0][1][1] = yMid;
//            children[0][2][0] = z1;
//            children[0][2][1] = z2;
//            children[1][0][0] = x1;
//            children[1][0][1] = x2;
//            children[1][1][0] = yMid2;
//            children[1][1][1] = y2;
//            children[1][2][0] = z1;
//            children[1][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], knownCorners[1], -1, knownCorners[3], -1, -1, knownCorners[6], -1};
            int[] corners2 = new int[] {-1, -1, knownCorners[2], -1, knownCorners[4], knownCorners[5], -1, knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, x2, y1, yMid, z1, z2, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(x1, x2, yMid2, y2, z1, z2, corners2));
        } else if (y1 == y2 && z1 == z2) {
            int xMid = x1 + (x2 - x1) / 2;
            int xMid2 = xMid + 1;
            if (xMid == x2) {
                xMid2--;
            }
//            children = new int[2][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = xMid;
//            children[0][1][0] = y1;
//            children[0][1][1] = y2;
//            children[0][2][0] = z1;
//            children[0][2][1] = z2;
//            children[1][0][0] = xMid2;
//            children[1][0][1] = x2;
//            children[1][1][0] = y1;
//            children[1][1][1] = y2;
//            children[1][2][0] = z1;
//            children[1][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], -1, knownCorners[2], knownCorners[3], -1, knownCorners[5], -1, -1};
            int[] corners2 = new int[] {-1, knownCorners[1], -1, -1, knownCorners[4], -1, knownCorners[6], knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, xMid, y1, y2, z1, z2, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(xMid2, x2, y1, y2, z1, z2, corners2));
        } else if (x1 == x2) {
            int yMid = y1 + (y2 - y1) / 2;
            int yMid2 = yMid + 1;
            if (yMid == y2) {
                yMid2--;
            }
            int zMid = z1 + (z2 - z1) / 2;
            int zMid2 = zMid + 1;
            if (zMid == z2) {
                zMid2--;
            }
//            children = new int[4][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = x2;
//            children[0][1][0] = y1;
//            children[0][1][1] = yMid;
//            children[0][2][0] = z1;
//            children[0][2][1] = zMid;
//            children[1][0][0] = x1;
//            children[1][0][1] = x2;
//            children[1][1][0] = yMid2;
//            children[1][1][1] = y2;
//            children[1][2][0] = z1;
//            children[1][2][1] = zMid;
//            children[2][0][0] = x1;
//            children[2][0][1] = x2;
//            children[2][1][0] = y1;
//            children[2][1][1] = yMid;
//            children[2][2][0] = zMid2;
//            children[2][2][1] = z2;
//            children[3][0][0] = x1;
//            children[3][0][1] = x2;
//            children[3][1][0] = yMid2;
//            children[3][1][1] = y2;
//            children[3][2][0] = zMid2;
//            children[3][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], knownCorners[1], -1, -1, -1, -1, -1, -1};
            int[] corners2 = new int[] {-1, -1, knownCorners[2], -1, knownCorners[4], -1, -1, -1, -1};
            int[] corners3 = new int[] {-1, -1, -1, knownCorners[3], -1, -1, knownCorners[6], -1};
            int[] corners4 = new int[] {-1, -1, -1, -1, -1, knownCorners[5], -1, knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, x2, y1, yMid, z1, zMid, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(x1, x2, yMid2, y2, z1, zMid, corners2));
//            results.add(new Tree(children[2], corners3));
            results.add(new Tree(x1, x2, y1, yMid, zMid2, z2, corners3));
//            results.add(new Tree(children[3], corners4));
            results.add(new Tree(x1, x2, yMid2, y2, zMid2, z2, corners4));
        } else if (y1 == y2) {
            int xMid = x1 + (x2 - x1) / 2;
            int xMid2 = xMid + 1;
            if (xMid == x2) {
                xMid2--;
            }
            int zMid = z1 + (z2 - z1) / 2;
            int zMid2 = zMid + 1;
            if (zMid == z2) {
                zMid2--;
            }
//            children = new int[4][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = xMid;
//            children[0][1][0] = y1;
//            children[0][1][1] = y2;
//            children[0][2][0] = z1;
//            children[0][2][1] = zMid;
//            children[1][0][0] = xMid2;
//            children[1][0][1] = x2;
//            children[1][1][0] = y1;
//            children[1][1][1] = y2;
//            children[1][2][0] = z1;
//            children[1][2][1] = zMid;
//            children[2][0][0] = x1;
//            children[2][0][1] = xMid;
//            children[2][1][0] = y1;
//            children[2][1][1] = y2;
//            children[2][2][0] = zMid2;
//            children[2][2][1] = z2;
//            children[3][0][0] = xMid2;
//            children[3][0][1] = x2;
//            children[3][1][0] = y1;
//            children[3][1][1] = y2;
//            children[3][2][0] = zMid2;
//            children[3][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], -1, knownCorners[2], -1, -1, -1, -1, -1};
            int[] corners2 = new int[] {-1, knownCorners[1], -1, -1, knownCorners[4], -1, -1, -1};
            int[] corners3 = new int[] {-1, -1, -1, knownCorners[3], -1, knownCorners[5], -1, -1};
            int[] corners4 = new int[] {-1, -1, -1, -1, -1, -1, knownCorners[6], knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, xMid, y1, y2, z1, zMid, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(xMid2, x2, y1, y2, z1, zMid, corners2));
//            results.add(new Tree(children[2], corners3));
            results.add(new Tree(x1, xMid, y1, y2, zMid2, z2, corners3));
//            results.add(new Tree(children[3], corners4));
            results.add(new Tree(xMid2, x2, y1, y2, zMid2, z2, corners4));
        } else if (z1 == z2) {
            int xMid = x1 + (x2 - x1) / 2;
            int xMid2 = xMid + 1;
            if (xMid == x2) {
                xMid2--;
            }
            int yMid = y1 + (y2 - y1) / 2;
            int yMid2 = yMid + 1;
            if (yMid == y2) {
                yMid2--;
            }
//            children = new int[4][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = xMid;
//            children[0][1][0] = y1;
//            children[0][1][1] = yMid;
//            children[0][2][0] = z1;
//            children[0][2][1] = z2;
//            children[1][0][0] = xMid2;
//            children[1][0][1] = x2;
//            children[1][1][0] = y1;
//            children[1][1][1] = yMid;
//            children[1][2][0] = z1;
//            children[1][2][1] = z2;
//            children[2][0][0] = x1;
//            children[2][0][1] = xMid;
//            children[2][1][0] = yMid2;
//            children[2][1][1] = y2;
//            children[2][2][0] = z1;
//            children[2][2][1] = z2;
//            children[3][0][0] = xMid2;
//            children[3][0][1] = x2;
//            children[3][1][0] = yMid2;
//            children[3][1][1] = y2;
//            children[3][2][0] = z1;
//            children[3][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], -1, -1, knownCorners[3], -1, -1, -1, -1};
            int[] corners2 = new int[] {-1, knownCorners[1], -1, -1, -1, -1, knownCorners[6], -1};
            int[] corners3 = new int[] {-1, -1, knownCorners[2], -1, -1, knownCorners[5], -1, -1};
            int[] corners4 = new int[] {-1, -1, -1, -1, knownCorners[4], -1, -1, knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
            results.add(new Tree(x1, xMid, y1, yMid, z1, z2, corners1));
//            results.add(new Tree(children[1], corners2));
            results.add(new Tree(xMid2, x2, y1, yMid, z1, z2, corners2));
//            results.add(new Tree(children[2], corners3));
            results.add(new Tree(x1, xMid, yMid2, y2, z1, z2, corners3));
//            results.add(new Tree(children[3], corners4));
            results.add(new Tree(xMid2, x2, yMid2, y2, z1, z2, corners4));
        } else {
            int xMid = x1 + (x2 - x1) / 2;
            int xMid2 = xMid + 1;
            if (xMid == x2) {
                xMid2--;
            }
            int yMid = y1 + (y2 - y1) / 2;
            int yMid2 = yMid + 1;
            if (yMid == y2) {
                yMid2--;
            }
            int zMid = z1 + (z2 - z1) / 2;
            int zMid2 = zMid + 1;
            if (zMid == z2) {
                zMid2--;
            }
//            children = new int[8][3][2];
//            children[0][0][0] = x1;
//            children[0][0][1] = xMid;
//            children[0][1][0] = y1;
//            children[0][1][1] = yMid;
//            children[0][2][0] = z1;
//            children[0][2][1] = zMid;
//            children[1][0][0] = xMid2;
//            children[1][0][1] = x2;
//            children[1][1][0] = y1;
//            children[1][1][1] = yMid;
//            children[1][2][0] = z1;
//            children[1][2][1] = zMid;
//            children[2][0][0] = x1;
//            children[2][0][1] = xMid;
//            children[2][1][0] = yMid2;
//            children[2][1][1] = y2;
//            children[2][2][0] = z1;
//            children[2][2][1] = zMid;
//            children[3][0][0] = x1;
//            children[3][0][1] = xMid;
//            children[3][1][0] = y1;
//            children[3][1][1] = yMid;
//            children[3][2][0] = zMid2;
//            children[3][2][1] = z2;
//            children[4][0][0] = xMid2;
//            children[4][0][1] = x2;
//            children[4][1][0] = yMid2;
//            children[4][1][1] = y2;
//            children[4][2][0] = z1;
//            children[4][2][1] = zMid;
//            children[5][0][0] = xMid2;
//            children[5][0][1] = x2;
//            children[5][1][0] = y1;
//            children[5][1][1] = yMid;
//            children[5][2][0] = zMid2;
//            children[5][2][1] = z2;
//            children[6][0][0] = x1;
//            children[6][0][1] = xMid;
//            children[6][1][0] = yMid2;
//            children[6][1][1] = y2;
//            children[6][2][0] = zMid2;
//            children[6][2][1] = z2;
//            children[7][0][0] = xMid2;
//            children[7][0][1] = x2;
//            children[7][1][0] = yMid2;
//            children[7][1][1] = y2;
//            children[7][2][0] = zMid2;
//            children[7][2][1] = z2;
            int[] corners1 = new int[] {knownCorners[0], -1, -1, -1, -1, -1, -1, -1};
            int[] corners2 = new int[] {-1, knownCorners[1], -1, -1, -1, -1, -1, -1};
            int[] corners3 = new int[] {-1, -1, knownCorners[2], -1, -1, -1, -1, -1};
            int[] corners4 = new int[] {-1, -1, -1, knownCorners[3], -1, -1, -1, -1};
            int[] corners5 = new int[] {-1, -1, -1, -1, knownCorners[4], -1, -1, -1};
            int[] corners6 = new int[] {-1, -1, -1, -1, -1, -1, knownCorners[6], -1};
            int[] corners7 = new int[] {-1, -1, -1, -1, -1, knownCorners[5], -1, -1};
            int[] corners8 = new int[] {-1, -1, -1, -1, -1, -1, -1, knownCorners[7]};
//            results.add(new Tree(children[0], corners1));
//            results.add(new Tree(children[1], corners2));
//            results.add(new Tree(children[2], corners3));
//            results.add(new Tree(children[3], corners4));
//            results.add(new Tree(children[4], corners5));
//            results.add(new Tree(children[5], corners6));
//            results.add(new Tree(children[6], corners7));
//            results.add(new Tree(children[7], corners8));
            results.add(new Tree(x1, xMid, y1, yMid, z1, zMid, corners1));
            results.add(new Tree(xMid2,x2, y1, yMid, z1, zMid, corners2));
            results.add(new Tree(x1, xMid, yMid2, y2, z1, zMid, corners3));
            results.add(new Tree(x1, xMid, y1, yMid, zMid2, z2, corners4));
            results.add(new Tree(xMid2, x2, yMid2, y2, z1, zMid, corners5));
            results.add(new Tree(xMid2, x2, y1, yMid, zMid2, z2, corners6));
            results.add(new Tree(x1, xMid, yMid2, y2, zMid2, z2, corners7));
            results.add(new Tree(xMid2, x2, yMid2, y2, zMid2, z2, corners8));
        }
        return results;
    }

//    public int[][] getCorners() {
//        int[][] corners = new int[8][3];
//        corners[0][0] = variables[0][0];
//        corners[0][1] = variables[1][0];
//        corners[0][2] = variables[2][0];
//        corners[1][0] = variables[0][1];
//        corners[1][1] = variables[1][0];
//        corners[1][2] = variables[2][0];
//        corners[2][0] = variables[0][0];
//        corners[2][1] = variables[1][1];
//        corners[2][2] = variables[2][0];
//        corners[3][0] = variables[0][0];
//        corners[3][1] = variables[1][0];
//        corners[3][2] = variables[2][1];
//        corners[4][0] = variables[0][1];
//        corners[4][1] = variables[1][1];
//        corners[4][2] = variables[2][0];
//        corners[5][0] = variables[0][0];
//        corners[5][1] = variables[1][1];
//        corners[5][2] = variables[2][1];
//        corners[6][0] = variables[0][1];
//        corners[6][1] = variables[1][0];
//        corners[6][2] = variables[2][1];
//        corners[7][0] = variables[0][1];
//        corners[7][1] = variables[1][1];
//        corners[7][2] = variables[2][1];
//        return corners;
//    }

    private double calcDistance(int x, int y, int z, int nX, int nY, int nZ) {
        double sum = 0;
        sum += Math.pow(Math.abs(x - nX), 2);
        sum += Math.pow(Math.abs(y - nY), 2);
        sum += Math.pow(Math.abs(z - nZ), 2);
        return Math.pow(sum, 0.5);
    }

    private int getClosestNode(int x, int y, int z, int[][] nodes) {
        double dist = -1;
        int closestNode = -1;
        int numNodes = nodes.length;
        for (int a = 0; a < numNodes; a++) {
            double newDist = calcDistance(x, y, z, nodes[a][0], nodes [a][1], nodes[a][2]);
            if (dist == -1) {
                closestNode = a;
                dist = newDist;
            }
            if (newDist < dist) {
                closestNode = a;
                dist = newDist;
            }
        }
        return closestNode;
    }

    public boolean solveCorners(int[][] nodes) {
//        int[][] corners = getCorners();
        boolean same = true;
//        for (int i = 0; i < 8; i++) {
//            if (knownCorners[i] == -1) {
//                knownCorners[i] = getClosestNode(corners[i], nodes);
//            }
//            if (knownCorners[i] != knownCorners[0]) {
//                same = false;
//            }
//        }
        if (knownCorners[0] == -1) {
            knownCorners[0] = getClosestNode(x1, y1, z1, nodes);
        }
        if (knownCorners[1] == -1) {
            knownCorners[1] = getClosestNode(x2, y1, z1, nodes);
            if (knownCorners[1] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[2] == -1) {
            knownCorners[2] = getClosestNode(x1, y2, z1, nodes);
            if (knownCorners[2] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[3] == -1) {
            knownCorners[3] = getClosestNode(x1, y1, z2, nodes);
            if (knownCorners[3] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[4] == -1) {
            knownCorners[4] = getClosestNode(x2, y2, z1, nodes);
            if (knownCorners[4] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[5] == -1) {
            knownCorners[5] = getClosestNode(x1, y2, z2, nodes);
            if (knownCorners[5] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[6] == -1) {
            knownCorners[6] = getClosestNode(x2, y1, z2, nodes);
            if (knownCorners[6] != knownCorners[0]) {
                same = false;
            }
        }
        if (knownCorners[7] == -1) {
            knownCorners[7] = getClosestNode(x2, y2, z2, nodes);
            if (knownCorners[7] != knownCorners[0]) {
                same = false;
            }
        }
        if (same) {
            closestNode = knownCorners[0];
        }
        return same;
    }

    public String toString() {
//        String result = "x: " + variables[0][0] + ", " + variables[0][1] + "\ny: " + variables[1][0] + ", " +
//                variables[1][1] + "\nz: " + variables[2][0] + ", " + variables[2][1] + "\nnode: " + closestNode + "\n";
        String result = "x: " + x1 + ", " + x2 + "\ny: " + y1 + ", " + y2 + "\nz: " + z1 + ", " + z2 +
                "\nnode: " + closestNode + "\n";
        return result;
    }

}