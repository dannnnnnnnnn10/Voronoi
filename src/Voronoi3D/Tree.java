package Voronoi3D;

import java.util.ArrayList;

public class Tree {

    private Tree parent;
    private ArrayList<Tree> children;
    private int numDimensions;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int z1;
    private int z2;
    private boolean allTheSame;
    private int closestNode;

    public Tree(int x1, int x2, int y1, int y2, int z1, int z2, Tree parent) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        this.parent = parent;
        numDimensions = calcDimensions();
        closestNode = -1;
    }

    private int calcDimensions() {
        int result = 0;
        if (x1 != x2) {
            result++;
        }
        if (y1 != y2) {
            result++;
        }
        if (z1 != z2) {
            result++;
        }
        return result;
    }

    public void propagate(boolean a) {
        allTheSame = a;
        if (a = true) {
            children = null;
        }
        else {
            createChildren();
        }
    }

    private void createChildren() {

    }

}