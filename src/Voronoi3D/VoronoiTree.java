package Voronoi3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VoronoiTree implements Runnable {

    private ArrayList<int[]> nodes;
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
        this.nodes = new ArrayList<>();
        results = new ArrayList<>();

        queue = new ConcurrentLinkedQueue<>();
        queue.add(tree);
    }

    public void addNode(int[] vars) {
        nodes.add(vars);
    }

    private double calcDistance(int[] vars, int[] node) {
        double sum = 0;
        for (int i = 0; i < vars.length; i++) {
            sum += Math.pow(Math.abs(vars[i] - node[i]), 2);
        }
        return Math.pow(sum, 0.5);
    }

    private int getClosestNode(int[] vars) {
        double dist = -1;
        int closestNode = -1;
        for (int a = 0; a < nodes.size(); a++) {
            double newDist = calcDistance(vars, nodes.get(a));
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
        String[] readFile = new String[100];
        int[][] params = new int[100][34];
        int index = 0;
        try {
            Scanner scan = new Scanner(new File("HighxLow.csv"));
                while (scan.hasNextLine()) {
                    readFile[index] = scan.nextLine();
                    index++;
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < readFile.length; i++) {
            String[] line = readFile[i].replace("\"", "").replace(" ", "").split(",");
            for (int j = 0; j < line.length; j++) {
                params[i][j] = Integer.parseInt(line[j]);
            }
        }
        long startTime;
        long endTime;
        long duration;
        VoronoiTree tree;
        for (int i = 0; i < params.length; i++) {
            int[] lengths = {params[i][0], params[i][1], params[i][2]};
            tree = new VoronoiTree(lengths);
            for (int j = 4; j < (4 + params[i][3]*3); j+=3) {
                int[] node = {params[i][j], params[i][j+1], params[i][j+2]};
                tree.addNode(node);
            }
            startTime = System.nanoTime();
            tree.solve();
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println(duration);

        }

//        int[] lengths = {2906, 474, 480};
//        VoronoiTree test = new VoronoiTree(lengths);
//        int[] node = {1, 1, 1};
//        int[] node2 = {36, 55, 234};
//        int[] node3 = {35, 234, 350};
//        int[] node4 = {113, 205, 453};
//        int[] node5 = {3, 24, 58};
//        int[] node6 = {73, 276, 56};
//        test.addNode(node);
//        test.addNode(node2);
//        test.addNode(node3);
//        test.addNode(node4);
//        test.addNode(node5);
//        test.addNode(node6);
//        long startTime;
//        long endTime;
//        long duration;
//        test.initializeQueue();
//        startTime = System.nanoTime();
//        Thread t1 = new Thread(test);
//        Thread t2 = new Thread(test);
//        Thread t3 = new Thread(test);
//        Thread t4 = new Thread(test);
//        Thread t5 = new Thread(test);
//        Thread t6 = new Thread(test);
//        Thread t7 = new Thread(test);
//        Thread t8 = new Thread(test);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000;
//        System.out.println("Tree took " + duration +" ms");
    }
}
