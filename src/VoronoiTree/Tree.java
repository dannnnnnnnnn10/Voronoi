package VoronoiTree;

import java.util.ArrayList;

public class Tree {

    private Tree parent;
    private ArrayList<Tree> children;
    private int numDimensions;
    private int[][] variables;
    private boolean isLeaf;
    private int closestNode;

    public Tree(int[][] vars, Tree parent) {
        variables = new int[vars.length][2];
        for (int i = 0; i < vars.length; i++) {
            variables[i][0] = vars[i][0];
            variables[i][1] = vars[i][1];
        }
        this.parent = parent;
        numDimensions = calcDimensions();
        closestNode = -1;
    }

    private int calcDimensions() {
        int result = 0;
        for (int i = 0; i < variables.length; i++) {
            if (variables[i][0] == variables[i][1]) {
                result++;
            }
        }
        return result;
    }

    public void propagate(boolean a) {
        isLeaf = a;
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