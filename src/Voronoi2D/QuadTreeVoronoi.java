package Voronoi2D;

import Voronoi3D.Tree;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuadTreeVoronoi implements Runnable {

	private static Point arrayOfSeeds[];

	private final static int SIZE = 1024;

	private static int canvas[] = new int[SIZE * SIZE];

	private ConcurrentLinkedQueue<Point[]> queue;

	public QuadTreeVoronoi(Point[] corners) {
		queue = new ConcurrentLinkedQueue<Point[]>();
		queue.add(corners);
	}

	// Find the id of the closest seed to the point p
	private static int findClosestSeed(Point p) {

		int n = arrayOfSeeds.length;
		int closestSeed = -1;
		int shortestDistance = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int distanceToThisSeed = (p.x - arrayOfSeeds[i].x) * (p.x - arrayOfSeeds[i].x)
					+ (p.y - arrayOfSeeds[i].y) * (p.y - arrayOfSeeds[i].y);
			if (distanceToThisSeed < shortestDistance) {
				closestSeed = i;
				shortestDistance = distanceToThisSeed;
			}
		}
		// System.out.println("In findClosestSeed. x is "+p.x+" y is "+p.y+" distance:
		// "+shortestDistance);

		canvas[p.y * SIZE + p.x] = closestSeed;
		return closestSeed;
	}

	// Fill a square area in the canvas delimited by the points p1,p2,p3 and p4
	public static void fillArea(Point p1, Point p2, Point p3, Point p4, int color) {
		/*
		 * System.out.println("----------------"); System.out.println("In fillArea: ");
		 * System.out.println(p1.x+" "+p1.y+"\n"+ p2.x+" "+p2.y+"\n"+
		 * p3.x+" "+p3.y+"\n"+ p4.x+" "+p4.y+"\n"); System.out.println("Color: "+color);
		 * System.out.println("----------------");
		 */
		for (int i = p1.x; i <= p2.x; i++) {
			for (int j = p3.y; j <= p4.y; j++) {
				canvas[j * SIZE + i] = color;
			}
		}
	}

	//
	// The heart of the algorithm.
	// The locations of the 4 points are passed counter-clockwise as
	// p1 p4
	// p2 p3
	//
	// The assumption is that 0,0 is on the upper left corner
	//

	public void run() {
		while (!queue.isEmpty()){
			if (queue.size() < 8) {
				if (queue.peek() != null) {
					queueQuad(queue.poll(), 2);
				}

			}
			else {
				if (queue.peek() != null) {
					queueQuad(queue.poll(), 1);
				}
			}
		}
	}

	public void initializeQueue() {
		queueQuad(queue.poll(), 2);
	}

	public void queueQuad(Point[] corners, int depth) {
		/*
		 * System.out.println("----------------");
		 * System.out.println(p1.x+" "+p1.y+"\n"+ p2.x+" "+p2.y+"\n"+
		 * p3.x+" "+p3.y+"\n"+ p4.x+" "+p4.y+"\n");
		 */

		Point p1 = corners[0];
		Point p2 = corners[1];
		Point p3 = corners[2];
		Point p4 = corners[3];

		int closestSeedP1 = findClosestSeed(p1);
		int closestSeedP2 = findClosestSeed(p2);
		int closestSeedP3 = findClosestSeed(p3);
		int closestSeedP4 = findClosestSeed(p4);
		/*
		 * System.out.println("Closest seeds: "+closestSeedP1+","+ closestSeedP2+","+
		 * closestSeedP3+","+ closestSeedP4); System.out.println("----------------");
		 */
		if (closestSeedP1 == closestSeedP2 && closestSeedP2 == closestSeedP3 && closestSeedP3 == closestSeedP4) {
			fillArea(p1, p2, p3, p4, closestSeedP1);
		} else {
			int middlePointX = (p1.x + p2.x) / 2;
			int middlePointY = (p1.y + p4.y) / 2;

			Point quad1p1 = p1;
			Point quad1p2 = new Point(middlePointX, p1.y);
			Point quad1p3 = new Point(middlePointX, middlePointY);
			Point quad1p4 = new Point(p1.x, middlePointY);
			Point[] a1 = new Point[]{quad1p1, quad1p2, quad1p3, quad1p4};

			Point quad2p1 = new Point(middlePointX + 1, p1.y);
			Point quad2p2 = p2;
			Point quad2p3 = new Point(p2.x, middlePointY);
			Point quad2p4 = new Point(middlePointX + 1, middlePointY);
			Point[] a2 = new Point[]{quad2p1, quad2p2, quad2p3, quad2p4};

			Point quad3p1 = new Point(middlePointX + 1, middlePointY + 1);
			Point quad3p2 = new Point(p2.x, middlePointY + 1);
			Point quad3p3 = p3;
			Point quad3p4 = new Point(middlePointX + 1, p3.y);
			Point[] a3 = new Point[]{quad3p1, quad3p2, quad3p3, quad3p4};

			Point quad4p1 = new Point(p1.x, middlePointY + 1);
			Point quad4p2 = new Point(middlePointX, middlePointY + 1);
			Point quad4p3 = new Point(middlePointX, p4.y);
			Point quad4p4 = p4;
			Point[] a4 = new Point[]{quad4p1, quad4p2, quad4p3, quad4p4};

			if (depth > 0) {
				queueQuad(a1, depth - 1);
				queueQuad(a2, depth - 1);
				queueQuad(a3, depth - 1);
				queueQuad(a4, depth - 1);
			}
			else {
				queue.add(a1);
				queue.add(a2);
				queue.add(a3);
				queue.add(a4);
			}
		}
	}

	public static void recursiveQuad(Point p1, Point p2, Point p3, Point p4) {
		/*
		 * System.out.println("----------------");
		 * System.out.println(p1.x+" "+p1.y+"\n"+ p2.x+" "+p2.y+"\n"+
		 * p3.x+" "+p3.y+"\n"+ p4.x+" "+p4.y+"\n");
		 */

		int closestSeedP1 = findClosestSeed(p1);
		int closestSeedP2 = findClosestSeed(p2);
		int closestSeedP3 = findClosestSeed(p3);
		int closestSeedP4 = findClosestSeed(p4);
		/*
		 * System.out.println("Closest seeds: "+closestSeedP1+","+ closestSeedP2+","+
		 * closestSeedP3+","+ closestSeedP4); System.out.println("----------------");
		 */
		if (closestSeedP1 == closestSeedP2 && closestSeedP2 == closestSeedP3 && closestSeedP3 == closestSeedP4) {
			fillArea(p1, p2, p3, p4, closestSeedP1);
		} else {
			int middlePointX = (p1.x + p2.x) / 2;
			int middlePointY = (p1.y + p4.y) / 2;

			Point quad1p1 = p1;
			Point quad1p2 = new Point(middlePointX, p1.y);
			Point quad1p3 = new Point(middlePointX, middlePointY);
			Point quad1p4 = new Point(p1.x, middlePointY);

			Point quad2p1 = new Point(middlePointX + 1, p1.y);
			Point quad2p2 = p2;
			Point quad2p3 = new Point(p2.x, middlePointY);
			Point quad2p4 = new Point(middlePointX + 1, middlePointY);

			Point quad3p1 = new Point(middlePointX + 1, middlePointY + 1);
			Point quad3p2 = new Point(p2.x, middlePointY + 1);
			Point quad3p3 = p3;
			Point quad3p4 = new Point(middlePointX + 1, p3.y);

			Point quad4p1 = new Point(p1.x, middlePointY + 1);
			Point quad4p2 = new Point(middlePointX, middlePointY + 1);
			Point quad4p3 = new Point(middlePointX, p4.y);
			Point quad4p4 = p4;

			recursiveQuad(quad1p1, quad1p2, quad1p3, quad1p4);
			recursiveQuad(quad2p1, quad2p2, quad2p3, quad2p4);
			recursiveQuad(quad3p1, quad3p2, quad3p3, quad3p4);
			recursiveQuad(quad4p1, quad4p2, quad4p3, quad4p4);

		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		arrayOfSeeds = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			arrayOfSeeds[i] = new Point(x, y);
		}
		// System.out.println("2^n is: "+twoToN);
		Point p1 = new Point(0, 0);
		Point p2 = new Point(SIZE - 1, 0);
		Point p3 = new Point(SIZE - 1, SIZE - 1);
		Point p4 = new Point(0, SIZE - 1);
		Point[] a = new Point[]{p1, p2, p3, p4};

		QuadTreeVoronoi test = new QuadTreeVoronoi(a);

		int numThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("" + numThreads);

		ExecutorService pool = Executors.newFixedThreadPool(numThreads);

		// int maxValue = IntStream.range(1,twoToN/2).map(e ->
		// findClosestSeed(e)).reduce(0,Integer::max);
		long startTime = System.nanoTime();
		recursiveQuad(p1, p2, p3, p4);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Sequential: " + duration + " milliseconds with " + n + " seeds.");
		// IntStream.range(0,SIZE*SIZE).forEach(e -> findClosestSeed(new
		// Voronoi2D.Point(e%SIZE,e/SIZE)));
		startTime = System.nanoTime();
		test.initializeQueue();
		for (int i = 0; i < numThreads; i++) {
			pool.submit(test);
		}
		pool.shutdown();
		try {
			pool.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Parallel: " + duration + " milliseconds with " + n + " seeds.");

//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE; j++) {
//				System.out.print(canvas[j * SIZE + i] + " ");
//			}
//			System.out.println();
//		}

	}
}
