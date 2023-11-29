package Voronoi3D;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VoronoiTree implements Runnable {

    private ArrayList<NodeForTree> nodeForTrees;
    private Tree tree;
    private ArrayList<String> results;

    private ConcurrentLinkedQueue<Tree> queue;

    public VoronoiTree(int[] lengths) {
        int[][] vars = new int[lengths.length][2];
        for (int i = 0; i < lengths.length; i++) {
            vars[i][0] = 0;
            vars[i][1] = lengths[i];
        }
        tree = new Tree(vars);
        this.nodeForTrees = new ArrayList<>();
        results = new ArrayList<>();

        queue = new ConcurrentLinkedQueue<>();
        queue.add(tree);
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
        return Math.pow(sum, 0.5);
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

    public void run() {
        while (!queue.isEmpty()){
            queueSolve(queue.poll());
        }
    }

    public void initializeQueue() {
        queueSolve(queue.poll());
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
        if (!same) {
            ArrayList<Tree> children = t.propagate();
            for (Tree a : children) {
                recursiveSolve(a);
            }
        }
        else {
            t.setClosestNode(firstNode);
            results.add(t.toString());
        }
    }

    private void queueSolve(Tree t) {
        ArrayList<int[]> corners = t.getCorners();
        boolean same = true;
        int firstNode = getClosestNode(corners.get(0));
        for (int i = 1; i < corners.size(); i++) {
            if (getClosestNode(corners.get(i)) != firstNode) {
                same = false;
                break;
            }
        }
        if (!same) {
            queue.addAll(t.propagate());
        }
        else {
            t.setClosestNode(firstNode);
//            System.out.println(t);
        }
    }

    public void print() {
        for (String r : results) {
            System.out.println(r);
        }
    }


    public static void main(String[] args) {
        int[] lengths = {2906, 474, 480};
        VoronoiTree test = new VoronoiTree(lengths);
        int[] node = {1, 1, 1};
        int[] node2 = {36, 55, 234};
        int[] node3 = {35, 234, 350};
        int[] node4 = {113, 205, 453};
        int[] node5 = {3, 24, 58};
        int[] node6 = {73, 276, 56};
        test.addNode(node);
        test.addNode(node2);
        test.addNode(node3);
        test.addNode(node4);
        test.addNode(node5);
        test.addNode(node6);
        long startTime;
        long endTime;
        long duration;
        test.initializeQueue();
        startTime = System.nanoTime();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);
        Thread t4 = new Thread(test);
        Thread t5 = new Thread(test);
        Thread t6 = new Thread(test);
        Thread t7 = new Thread(test);
        Thread t8 = new Thread(test);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Tree took " + duration +" ms");
    }
}
