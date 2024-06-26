package Voronoi3D;

import Voronoi2D.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VoronoiTree implements Runnable {

    private int[][] nodes;
    private int numNodes;
    private int currentNodeCount;
    private long maxMemUsage;
    private Tree tree;
//    private ArrayList<String> results;

    private ConcurrentLinkedQueue<Tree> queue;

    public VoronoiTree(int[] lengths, int numNodes) {
        int[][] vars = new int[lengths.length][2];
        for (int i = 0; i < lengths.length; i++) {
            vars[i][0] = 0;
            vars[i][1] = lengths[i]-1;
        }
        tree = new Tree(vars);
        nodes = new int[numNodes][3];
        currentNodeCount = 0;
        maxMemUsage = -1;
        this.numNodes = numNodes;

        queue = new ConcurrentLinkedQueue<>();
        queue.add(tree);
    }

    public void addNode(int[] vars) {
        if (currentNodeCount < numNodes) {
            nodes[currentNodeCount] = vars;
            currentNodeCount++;
        }
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
        for (int a = 0; a < numNodes; a++) {
            double newDist = calcDistance(vars, nodes[a]);
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
            if (queue.size() < 20) {
                if (queue.peek() != null) {
                    queueSolve(queue.poll(), 8);
                }

            }
            else {
                if (queue.peek() != null) {
                    queueSolve(queue.poll(), 8);
                }
            }
        }
    }

    public void initializeQueue() {
        queueSolve(queue.poll(), 2);
    }

    private void recursiveSolve(Tree t) {
//        int[][] corners = t.getCorners();
//        boolean same = true;
//        int firstNode = getClosestNode(corners[0]);
//        for (int i = 1; i < 8; i++) {
//            if (getClosestNode(corners[i]) != firstNode) {
//                same = false;
//                break;
//            }
//        }
        if (!t.solveCorners(nodes)) {
            Tree[] children = t.propagate();
            for (int i = 0; i < children.length; i++) {
                recursiveSolve(children[i]);
            }
        }
        else {
            Runtime rt = Runtime.getRuntime();
//            rt.gc();
            long memUsage = rt.totalMemory() - rt.freeMemory();
            if (memUsage > maxMemUsage) {
                maxMemUsage = memUsage;
            }
        }
    }

    private void queueSolve(Tree t, int depth) {
//        int[][] corners = t.getCorners();
//        boolean same = true;
//        int firstNode = getClosestNode(corners[0]);
//        for (int i = 1; i < 8; i++) {
//            if (getClosestNode(corners[i]) != firstNode) {
//                same = false;
//                break;
//            }
//        }
        if (!t.solveCorners(nodes)) {
            Tree[] children = t.propagate();
            if (depth == 0) {
                for (int i = 0; i < children.length; i++) {
                    queue.add(children[i]);
                }
            }
            else {
                for (int i = 0; i < children.length; i++) {
                    queueSolve(children[i], depth - 1);
                }
            }
        }
        else {
            Runtime rt = Runtime.getRuntime();
//            rt.gc();
            long memUsage = rt.totalMemory() - rt.freeMemory();
            if (memUsage > maxMemUsage) {
                maxMemUsage = memUsage;
            }
        }
    }

    public long getMaxMemUsage() {
        return maxMemUsage;
    }

    public String print() {
        return tree.toString();
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

//        boolean converge = false;
//        long lastMemUsage = -1;
//        while (!converge) {
//            int[] lengths = {params[0][0], params[0][1], params[0][2]};
//            tree = new VoronoiTree(lengths, params[0][3]);
//            for (int j = 4; j < (4 + params[0][3]*3); j+=3) {
//                int[] node = {params[0][j], params[0][j+1], params[0][j+2]};
//                tree.addNode(node);
//            }
//            Runtime rt = Runtime.getRuntime();
//            rt.gc();
//            startTime = System.nanoTime();
////            long memUsage = rt.totalMemory() - rt.freeMemory();
////            System.out.println("Memory being used pre-solve call: " + memUsage);
//            tree.solve();
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000000;
//            System.out.println(duration);
//            System.out.println("Max memory used: " + tree.getMaxMemUsage());
//            if (Math.abs(tree.getMaxMemUsage()-lastMemUsage) > tree.getMaxMemUsage()*0.01) {
//                System.out.println("Not yet converged");
//                lastMemUsage = tree.getMaxMemUsage();
//            }
//            else {
//                System.out.println("Converged");
//                converge = true;
//            }
//        }

        for (int i = 0; i < params.length; i++) {
            int[] lengths = {params[i][0], params[i][1], params[i][2]};
            tree = new VoronoiTree(lengths, params[i][3]);
            for (int j = 4; j < (4 + params[i][3]*3); j+=3) {
                int[] node = {params[i][j], params[i][j+1], params[i][j+2]};
                tree.addNode(node);
            }
//            Runtime rt = Runtime.getRuntime();
//            rt.gc();
//            startTime = System.nanoTime();
////            long memUsage = rt.totalMemory() - rt.freeMemory();
////            System.out.println("Memory being used pre-solve call: " + memUsage);
//            tree.solve();
//            endTime = System.nanoTime();
//            duration = (endTime - startTime) / 1000000;
//            System.out.println("Sequential: " + duration);
//            System.out.println("Max memory used: " + tree.getMaxMemUsage());

            int numThreads = 20;
//            System.out.println("" + numThreads);
            Runtime.getRuntime().gc();
            ExecutorService pool = Executors.newFixedThreadPool(numThreads);
            startTime = System.nanoTime();
            tree.initializeQueue();
            for (int k = 0; k < numThreads; k++) {
                pool.submit(tree);
            }
            pool.shutdown();
            try {
                pool.awaitTermination(100, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("" + tree.getMaxMemUsage());

        }
    }
}
