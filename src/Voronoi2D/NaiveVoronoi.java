package Voronoi2D;

import java.util.Scanner;

public class NaiveVoronoi {

	private static Point arrayOfSeeds[];

	// private final static int SIZE=16;
	private final static int SIZE = 2048;
	// private final static int SIZE=8;

	private static int canvas[] = new int[SIZE * SIZE];

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

	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		arrayOfSeeds = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			arrayOfSeeds[i] = new Point(x, y);
			
		}
		// System.out.println("2^n is: "+twoToN);

		// int maxValue = IntStream.range(1,twoToN/2).map(e ->
		// findClosestSeed(e)).reduce(0,Integer::max);
		long startTime = System.nanoTime();

		Point point = new Point();
		for(point.x = 0; point.x < SIZE; point.x++)
			for(point.y = 0; point.y < SIZE; point.y++) {
				canvas[point.x * SIZE + point.y] = findClosestSeed(point);
			}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Time for naive Voronoi: " + duration + " miliseconds with " + n + " seeds.");

//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE; j++) {
//				System.out.print(canvas[j * SIZE + i] + " ");
//			}
//			System.out.println();
//		}

	}
}
