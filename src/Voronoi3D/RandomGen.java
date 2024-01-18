package Voronoi3D;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class RandomGen {

    private int x;
    private int y;
    private int z;
    private ArrayList<Node> nodes;
    private ArrayList<NodeForTree> treeNodes;
    int fastest;

    public RandomGen (int xMin, int xMax, int yMin, int yMax, int zMin, int zMax, int nodesMin, int nodesMax) {
        fastest = 0;
        Random rand = new Random();
        boolean tooBig = true;
        int numNodes;
        while(tooBig) {
            x = rand.nextInt(xMax - xMin + 1) + xMin;
            y = rand.nextInt(yMax - yMin + 1) + yMin;
            z = rand.nextInt(zMax - zMin + 1) + zMin;
            if (x * y * z < 800000000) {
                tooBig = false;
            }
        }
        if (nodesMin == nodesMax) {
            numNodes = nodesMin;
        }
        else {
            numNodes = rand.nextInt(nodesMax - nodesMin + 1) + nodesMin;
        }
        nodes = new ArrayList<Node>();
        treeNodes = new ArrayList<NodeForTree>();
        Node node;
        boolean duplicate;
        for (int i = 0; i < numNodes; i++) {
            node = new Node(rand.nextInt(x) + 1, rand.nextInt(y) + 1, rand.nextInt(z) + 1);
            duplicate = false;
            for (int j = 0; j < nodes.size(); j++) {
                if (node.getX() == nodes.get(j).getX() && node.getY() == nodes.get(j).getY()
                        && node.getZ() == nodes.get(j).getZ()) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                nodes.add(node);
                treeNodes.add(new NodeForTree(node.nodeConversion()));
            }
            else {
                i--;
            }
        }
    }

    public RandomGen (int areaRange, int numNodes) {
        fastest = 0;
        Random rand = new Random();
        boolean outOfRange = true;
        int maxSideLength;
        int minSideLength;
        if (areaRange == 0) {
            minSideLength = 10;
            maxSideLength = 500;
        }
        else if (areaRange == 1) {
            minSideLength = 100;
            maxSideLength = 1000;
        }
        else {
            minSideLength = 250;
            maxSideLength = 2000;
        }
        while(outOfRange) {
            x = rand.nextInt(maxSideLength - minSideLength + 1) + minSideLength;
            y = rand.nextInt(maxSideLength - minSideLength + 1) + minSideLength;
            z = rand.nextInt(maxSideLength - minSideLength + 1) + minSideLength;
            if (areaRange == 0) {
                if (x * y * z < 2100000 && x * y * z > 1900000) {
                    outOfRange = false;
                }
                else if (10 * y * z < 2000000 && 500 * y * z > 2000000) {
                    x = 2000000 / (y * z);
                    outOfRange = false;
                }
                else if (10 * x * z < 2000000 && 500 * x * z > 2000000) {
                    y = 2000000 / (x * z);
                    outOfRange = false;
                }
                else if (10 * x * y < 2000000 && 500 * x * y > 2000000) {
                    z = 2000000 / (x * y);
                    outOfRange = false;
                }
            }
            else if (areaRange == 1) {
                if (x * y * z < 105000000 && x * y * z > 95000000) {
                    outOfRange = false;
                }
                else if (100 * y * z < 100000000 && 1000 * y * z > 100000000) {
                    x = 100000000 / (y * z);
                    outOfRange = false;
                }
                else if (100 * x * z < 100000000 && 1000 * x * z > 100000000) {
                    y = 100000000 / (x * z);
                    outOfRange = false;
                }
                else if (100 * x * y < 100000000 && 1000 * x * y > 100000000) {
                    z = 100000000 / (x * y);
                    outOfRange = false;
                }
            }
            else {
                if (x * y * z < 1050000000 && x * y * z > 950000000) {
                    outOfRange = false;
                }
                else if (250 * y * z < 1000000000 && 2000 * y * z > 1000000000) {
                    x = 1000000000 / (y * z);
                    outOfRange = false;
                }
                else if (250 * x * z < 1000000000 && 2000 * x * z > 1000000000) {
                    y = 1000000000 / (x * z);
                    outOfRange = false;
                }
                else if (250 * x * y < 1000000000 && 2000 * x * y > 1000000000) {
                    z = 1000000000 / (x * y);
                    outOfRange = false;
                }
            }
        }
        nodes = new ArrayList<Node>();
        treeNodes = new ArrayList<NodeForTree>();
        Node node;
        boolean duplicate;
        for (int i = 0; i < numNodes; i++) {
            node = new Node(rand.nextInt(x) + 1, rand.nextInt(y) + 1, rand.nextInt(z) + 1);
            duplicate = false;
            for (int j = 0; j < nodes.size(); j++) {
                if (node.getX() == nodes.get(j).getX() && node.getY() == nodes.get(j).getY()
                        && node.getZ() == nodes.get(j).getZ()) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                nodes.add(node);
                treeNodes.add(new NodeForTree(node.nodeConversion()));
            }
            else {
                i--;
            }
        }
    }

    private long bruteSolution() {
        long startTime;
        long endTime;
        long duration;
        Voronoi3D test = new Voronoi3D(x, y, z);
        for (int i = 0; i < nodes.size(); i++) {
            test.addNode(nodes.get(i));
        }
        startTime = System.nanoTime();
        test.bruteForce();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        return duration;
    }

    private long cleanSolution() {
        long startTime;
        long endTime;
        long duration;
        Voronoi3D test = new Voronoi3D(x, y, z);
        for (int i = 0; i < nodes.size(); i++) {
            test.addNode(nodes.get(i));
        }
        startTime = System.nanoTime();
        test.solve(0, x-1, 0, y-1, 0, z-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        return duration;
    }

    private long roughSolution() {
        long startTime;
        long endTime;
        long duration;
        Voronoi3D test = new Voronoi3D(x, y, z);
        for (int i = 0; i < nodes.size(); i++) {
            test.addNode(nodes.get(i));
        }
        startTime = System.nanoTime();
        test.solveRoughCut(0, x-1, 0, y-1, 0, z-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        return duration;
    }

//    private long treeSolution() {
//        long startTime;
//        long endTime;
//        long duration;
//        VoronoiTree test = new VoronoiTree(new int[]{x, y, z});
//        for (int i = 0; i < treeNodes.size(); i++) {
//            test.addNode(treeNodes.get(i));
//        }
//        startTime = System.nanoTime();
//        test.solve();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000;
//        return duration;
//    }

    public String compareSolutions() {
        String result = "";
//        long bruteDuration = bruteSolution();
//        result += "Brute force: " + bruteDuration + " ms\n";
//        long cleanDuration = cleanSolution();
//        result += "Clean Divide: " + cleanDuration + " ms\n";
        long roughDuration = roughSolution();
        result += "Rough Divide: " + roughDuration + " ms\n";
//        long treeDuration = treeSolution();
//        result += "Tree Divide: " + treeDuration + " ms\n";

//        if (roughDuration < cleanDuration) {
//            if (roughDuration < bruteDuration) {
//                result += "Rough Divide was the fastest\n";
//                fastest = 3;
//            }
//            else {
//                result += "Brute Force was the fastest\n";
//                fastest = 1;
//            }
//        }
//        else {
//            if (cleanDuration < bruteDuration) {
//                result += "Clean Divide was the fastest\n";
//                fastest = 2;
//            }
//            else {
//                result += "Brute Force was the fastest\n";
//                fastest = 1;
//            }
//        }
        return result;
    }

    public String seedInfo() {
        String result = "";
        result += "x Length = " + x + "\n";
        result += "y Length = " + y + "\n";
        result += "z Length = " + z + "\n";
        result += "Number of Nodes = " + nodes.size() + "\n";
        result += "Node List:\n";
        for (int j = 0; j < nodes.size(); j++) {
            result += nodes.get(j).toString() + "\n";
        }
        return result;
    }

    public String seedInfoMinimal() {
        String result = "";
        result += x + ";";
        result += y + ";";
        result += z + ";";
        result += + nodes.size() + ";";
        return result;
    }

    public String nodeList() {
        String result = "";
        for (int j = 0; j < nodes.size(); j++) {
            result += nodes.get(j).toString() + ";";
        }
        return result;
    }

    public String compareSolutionsMinimal() {
        String result = "";
//        long bruteDuration = bruteSolution();
//        result += bruteDuration + ";";
        long cleanDuration = cleanSolution();
        result += cleanDuration + ";";
        long roughDuration = roughSolution();
        result += roughDuration + ";";
        return result;
    }

    public int getFastest() {
        return fastest;
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("How many test runs would you like to do?");
//        int n = scan.nextInt();
        RandomGen test = new RandomGen(2, 10);
        System.out.println(test.compareSolutions());
//        RandomGen test;
//        int bruteWins = 0;
//        int cleanWins = 0;
//        int roughWins = 0;
//        StringBuilder results = new StringBuilder("");
//        for (int i = 0; i < n; i++) {
//            test = new RandomGen(2, 20, 2, 20, 2, 20, 5, 10);
//            results.append("" + test.seedInfoMinimal() + test.compareSolutionsMinimal() + test.nodeList() + "\n");
//            if (test.getFastest() == 1) {
//                bruteWins++;
//            } else if (test.getFastest() == 2) {
//                cleanWins++;
//            } else {
//                roughWins++;
//            }
//            System.out.println("Run " + (i+1) + " of " + n + " finished.");
//        }
//        try {
//            FileWriter myWriter = new FileWriter("resultsLowxLow26to100.txt");
//            myWriter.write(results.toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }
}
