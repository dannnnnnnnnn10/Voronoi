package Voronoi3D;

import java.util.ArrayList;

public class Tree {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int z1;
    private int z2;
    private int closestNode;
    private int c1;
    private int c2;
    private int c3;
    private int c4;
    private int c5;
    private int c6;
    private int c7;
    private int c8;
    private Tree[] childList;

    public Tree(int[][] vars) {
        x1 = vars[0][0];
        x2 = vars[0][1];
        y1 = vars[1][0];
        y2 = vars[1][1];
        z1 = vars[2][0];
        z2 = vars[2][1];
        closestNode = -1;
        c1 = c2 = c3 = c4 = c5 = c6 = c7 = c8 = -1;
    }

    public Tree(int x1, int x2, int y1, int y2, int z1, int z2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        closestNode = -1;
        c1 = c2 = c3 = c4 = c5 = c6 = c7 = c8 = -1;
    }

    public Tree(int x1, int x2, int y1, int y2, int z1, int z2, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        closestNode = -1;
        this.c1= c1;
        this.c2= c2;
        this.c3= c3;
        this.c4= c4;
        this.c5= c5;
        this.c6= c6;
        this.c7= c7;
        this.c8= c8;

    }

    public Tree(int[][] vars, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8) {
        x1 = vars[0][0];
        x2 = vars[0][1];
        y1 = vars[1][0];
        y2 = vars[1][1];
        z1 = vars[2][0];
        z2 = vars[2][1];
        closestNode = -1;
        this.c1= c1;
        this.c2= c2;
        this.c3= c3;
        this.c4= c4;
        this.c5= c5;
        this.c6= c6;
        this.c7= c7;
        this.c8= c8;
    }

    public void setClosestNode (int node) {
        closestNode = node;
    }

    public Tree[] propagate() {
        if (x1 == x2 && y1 == y2) {
            int zMid = z1 + (z2 - z1) / 2;
            int zMid2 = zMid + 1;
            if (zMid == z2) {
                zMid2--;
            }
            childList = new Tree[2];
            childList[0] = (new Tree(x1, x2, y1, y2, z1, zMid, c1, c2, c3, -1, c5, -1, -1, -1));
            childList[1] = (new Tree(x1, x2, y1, y2, zMid2, z2, -1, -1, -1, c4, -1, c6, c7, c8));
        } else if (x1 == x2 && z1 == z2) {
            int yMid = y1 + (y2 - y1) / 2;
            int yMid2 = yMid + 1;
            if (yMid == y2) {
                yMid2--;
            }
            childList = new Tree[2];
            childList[0] = (new Tree(x1, x2, y1, yMid, z1, z2, c1, c2, -1, c4, -1, -1, c7, -1));
            childList[1] = (new Tree(x1, x2, yMid2, y2, z1, z2, -1, -1, c3, -1, c5, c6, -1, c8));
        } else if (y1 == y2 && z1 == z2) {
            int xMid = x1 + (x2 - x1) / 2;
            int xMid2 = xMid + 1;
            if (xMid == x2) {
                xMid2--;
            }
            childList = new Tree[2];
            childList[0] = (new Tree(x1, xMid, y1, y2, z1, z2, c1, -1, c3, c4, -1, c6, -1, -1));
            childList[1] = (new Tree(xMid2, x2, y1, y2, z1, z2, -1, c2, -1, -1, c5, -1, c7, c8));
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
            childList = new Tree[4];
            childList[0] = (new Tree(x1, x2, y1, yMid, z1, zMid, c1, c2, -1, -1, -1, -1, -1, -1));
            childList[1] = (new Tree(x1, x2, yMid2, y2, z1, zMid, -1, -1, c3, -1, c5, -1, -1, -1));
            childList[2] = (new Tree(x1, x2, y1, yMid, zMid2, z2, -1, -1, -1, c4, -1, -1, c7, -1));
            childList[3] = (new Tree(x1, x2, yMid2, y2, zMid2, z2, -1, -1, -1, -1, -1, c6, -1, c8));
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
            childList = new Tree[4];
            childList[0] = (new Tree(x1, xMid, y1, y2, z1, zMid, c1, -1, c3, -1, -1, -1, -1, -1));
            childList[1] = (new Tree(xMid2, x2, y1, y2, z1, zMid, -1, c2, -1, -1, c5, -1, -1, -1));
            childList[2] =(new Tree(x1, xMid, y1, y2, zMid2, z2, -1, -1, -1, c4, -1, c6, -1, -1));
            childList[3] = (new Tree(xMid2, x2, y1, y2, zMid2, z2, -1, -1, -1, -1, -1, -1, c7, c8));
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
            childList = new Tree[4];
            childList[0] = (new Tree(x1, xMid, y1, yMid, z1, z2, c1, -1, -1, c4, -1, -1, -1, -1));
            childList[1] = (new Tree(xMid2, x2, y1, yMid, z1, z2, -1, c2, -1, -1, -1, -1, c7, -1));
            childList[2] = (new Tree(x1, xMid, yMid2, y2, z1, z2, -1, -1, c3, -1, -1, c6, -1, -1));
            childList[3] = (new Tree(xMid2, x2, yMid2, y2, z1, z2, -1, -1, -1, -1, c5, -1, -1, c8));
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
            childList = new Tree[8];
            childList[0] = (new Tree(x1, xMid, y1, yMid, z1, zMid, c1, -1, -1, -1, -1, -1, -1, -1));
            childList[1] = (new Tree(xMid2,x2, y1, yMid, z1, zMid, -1, c2, -1, -1, -1, -1, -1, -1));
            childList[2] = (new Tree(x1, xMid, yMid2, y2, z1, zMid, -1, -1, c3, -1, -1, -1, -1, -1));
            childList[3] = (new Tree(x1, xMid, y1, yMid, zMid2, z2, -1, -1, -1, c4, -1, -1, -1, -1));
            childList[4] = (new Tree(xMid2, x2, yMid2, y2, z1, zMid, -1, -1, -1, -1, c5, -1, -1, -1));
            childList[5] = (new Tree(xMid2, x2, y1, yMid, zMid2, z2, -1, -1, -1, -1, -1, -1, c7, -1));
            childList[6] = (new Tree(x1, xMid, yMid2, y2, zMid2, z2, -1, -1, -1, -1, -1, c6, -1, -1));
            childList[7] = (new Tree(xMid2, x2, yMid2, y2, zMid2, z2, -1, -1, -1, -1, -1, -1, -1, c8));
        }
        return childList;
    }

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
        boolean same = true;
        if (c1 == -1) {
            c1 = getClosestNode(x1, y1, z1, nodes);
        }
        if (c2 == -1) {
            c2 = getClosestNode(x2, y1, z1, nodes);
            if (c2 != c1) {
                same = false;
            }
        }
        if (c3 == -1) {
            c3 = getClosestNode(x1, y2, z1, nodes);
            if (c3 != c1) {
                same = false;
            }
        }
        if (c4 == -1) {
            c4 = getClosestNode(x1, y1, z2, nodes);
            if (c4 != c1) {
                same = false;
            }
        }
        if (c5 == -1) {
            c5 = getClosestNode(x2, y2, z1, nodes);
            if (c5 != c1) {
                same = false;
            }
        }
        if (c6 == -1) {
            c6 = getClosestNode(x1, y2, z2, nodes);
            if (c6 != c1) {
                same = false;
            }
        }
        if (c7 == -1) {
            c7 = getClosestNode(x2, y1, z2, nodes);
            if (c7 != c1) {
                same = false;
            }
        }
        if (c8 == -1) {
            c8 = getClosestNode(x2, y2, z2, nodes);
            if (c8 != c1) {
                same = false;
            }
        }
        if (same) {
            closestNode = c1;
        }
        return same;
    }

    public String toString() {
        String result = "";
        if (closestNode != -1) {
//        String result = "x: " + variables[0][0] + ", " + variables[0][1] + "\ny: " + variables[1][0] + ", " +
//                variables[1][1] + "\nz: " + variables[2][0] + ", " + variables[2][1] + "\nnode: " + closestNode + "\n";
            result += x1 + "," + x2 + "," + y1 + "," + y2 + "," + z1 + "," + z2 + "," + closestNode + "\n";
        }
        else {
            for (int i = 0; i < childList.length; i++) {
                result += childList[i];
            }
        }
        return result;
    }

}