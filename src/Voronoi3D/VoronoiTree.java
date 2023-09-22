package Voronoi3D;

import java.util.ArrayList;

public class VoronoiTree {

    private int[] lengths;
    private ArrayList<NodeForTree> nodeForTrees;
    private Tree tree;

    public VoronoiTree(int[] lengths) {
        this.lengths = lengths;
        int[][] vars = new int[lengths.length][2];
        for (int i = 0; i < lengths.length; i++) {
            vars[i][0] = 0;
            vars[i][1] = lengths[i];
        }
        tree = new Tree(vars, null);
        this.nodeForTrees = new ArrayList<NodeForTree>();
    }

    public void addNode(int[] vars) {
        nodeForTrees.add(new NodeForTree(vars));
    }

    public void addNode(NodeForTree nodeForTree) {
        nodeForTrees.add(nodeForTree);
    }

    private double calcDistance(int[] vars, NodeForTree nodeForTree) {
        double sum = 0;
        for (int i = 0; i < vars.length; i++) {
            sum += Math.pow(Math.abs(vars[i] - nodeForTree.getVars()[i]), 2);
        }
        double distance = Math.pow(sum, 0.5);
        return distance;
    }

    private int getClosestNode(int[] vars) {
        double dist = -1;
        int closestNode = -1;
        for (int a = 0; a < nodeForTrees.size(); a++) {
            double newDist = calcDistance(vars, nodeForTrees.get(a));
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

    public void solve() {
        recursiveSolve(tree);
    }

    private void recursiveSolve(Tree t) {
        ArrayList<int[]> corners = t.getCorners();
        boolean same = true;
        int firstNode = getClosestNode(corners.get(0));
        for (int i = 1; i < corners.size(); i++) {
            if (getClosestNode(corners.get(i)) != firstNode) {
                same = false;
                break;
            }
        }
        t.propagate(same);
        if (!same) {
            for (Tree a : t.getChildren()) {
                recursiveSolve(a);
            }
        }
        else {
            t.setClosestNode(firstNode);
        }
    }

    public String print() {
        return tree.toString();
    }


    public static void main(String[] args) {
        int[] lengths = {2190, 3476, 5480};
        VoronoiTree test = new VoronoiTree(lengths);
        int[] node = {1, 1, 1};
        int[] node2 = {376, 55, 234};
        int[] node3 = {35, 234, 5};
        int[] node4 = {1233, 2, 5};
        int[] node5 = {3, 24, 5};
        int[] node6 = {3, 2, 56};
        test.addNode(node);
        test.addNode(node2);
        test.addNode(node3);
        test.addNode(node4);
        test.addNode(node5);
        test.addNode(node6);
        long startTime;
        long endTime;
        long duration;
        startTime = System.nanoTime();
        test.solve();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Tree took " + duration +" ms");
    }
//    public static void main(String[] args) {
//        long startTime;
//        long endTime;
//        long duration;
//        Voronoi3D test;
//        test = new Voronoi3D(1000, 1000, 800);
//        test.addNode(7, 7, 7);
//        test.addNode(0, 0, 0);
//        test.addNode(11, 11, 26);
//        test.addNode(465, 2, 56);
//        test.addNode(987, 78, 2);
//        test.addNode(123, 123, 12);
//        test.addNode(110, 122, 65);
//        startTime = System.nanoTime();
//        test.bruteForce();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000;
//        System.out.println("The brute force method took " + duration + " ms to calculate");
//
//        test = new Voronoi3D(1000, 1000, 800);
//        test.addNode(7, 7, 7);
//        test.addNode(0, 0, 0);
//        test.addNode(11, 11, 26);
//        test.addNode(465, 2, 56);
//        test.addNode(987, 78, 2);
//        test.addNode(123, 123, 12);
//        test.addNode(110, 122, 65);
//        startTime = System.nanoTime();
//        test.solve(0, 999, 0, 999, 0, 799);
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000;
//        System.out.println("The divide method took " + duration + " ms to calculate");
//
//        test = new Voronoi3D(1000, 1000, 800);
//        test.addNode(7, 7, 7);
//        test.addNode(0, 0, 0);
//        test.addNode(11, 11, 26);
//        test.addNode(465, 2, 56);
//        test.addNode(987, 78, 2);
//        test.addNode(123, 123, 12);
//        test.addNode(110, 122, 65);
//        startTime = System.nanoTime();
//        test.solveRoughCut(0, 999, 0, 999, 0, 799);
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000;
//        System.out.println("The rough divide method took " + duration + " ms to calculate");

//        if (test2.print().equals(test3.print())) {
//            System.out.println("Strings are the same");
//        }
//    }
}
