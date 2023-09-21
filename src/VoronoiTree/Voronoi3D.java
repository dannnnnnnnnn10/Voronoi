package VoronoiTree;

import java.util.ArrayList;

public class Voronoi3D {

    private int xLength;
    private int yLength;
    private int zLength;
    private ArrayList<Node> nodes;
    private int[][][] grid;

    public Voronoi3D(int xLength, int yLength, int zLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
        grid = new int[xLength][yLength][zLength];
        this.nodes = new ArrayList<Node>();
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    grid[i][j][k] = -1;
                }
            }
        }
    }

    public void addNode(int x, int y, int z) {
        nodes.add(new Node(x, y, z));
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    private double calcDistance(int x, int y, int z, Node node) {
        double pointX = x;
        double pointY = y;
        double pointZ = z;
        double nodeX = node.getX();
        double nodeY = node.getY();
        double nodeZ = node.getZ();
        double xDiff = Math.abs(pointX-nodeX);
        double yDiff = Math.abs(pointY-nodeY);
        double zDiff = Math.abs(pointZ-nodeZ);
        double xyDiff = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        double distance = Math.sqrt(xyDiff+xyDiff + zDiff*zDiff);

        return distance;
    }

    public void bruteForce(){
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    int closestNode = getClosestNode(i, j, k);
                    grid[i][j][k] = closestNode;
                }
            }
        }
    }

    private int getClosestNode(int x, int y, int z) {
        double dist = -1;
        int closestNode = -1;
        for (int a = 0; a < nodes.size(); a++) {
            double newDist = calcDistance(x, y, z, nodes.get(a));
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

    public void solveRoughCut(int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {
        int xLength = (xMax - xMin + 1);
        int yLength = (yMax - yMin + 1);
        int zLength = (zMax - zMin + 1);
        int xHalfLength = xLength/2;
        int yHalfLength = yLength/2;
        int zHalfLength = zLength/2;
        int xOffset = xHalfLength - 1;
        int xMidLow = xMin + xOffset;
        if (xLength%2 == 1) {
            xMidLow++;
        }
        int xMidHigh = xMax - xOffset;
        int yOffset = yHalfLength - 1;
        int yMidLow = yMin + yOffset;
        if (yLength%2 == 1) {
            yMidLow++;
        }
        int yMidHigh = yMax - yOffset;
        int zOffset = zHalfLength - 1;
        int zMidLow = zMin + zOffset;
        if (zLength%2 == 1) {
            zMidLow++;
        }
        int zMidHigh = zMax - zOffset;
        if (grid[xMin][yMin][zMin] == -1) {
            grid[xMin][yMin][zMin] = getClosestNode(xMin, yMin, zMin);
        }
        if (grid[xMin][yMin][zMax] == -1) {
            grid[xMin][yMin][zMax] = getClosestNode(xMin, yMin, zMax);
        }
        if (grid[xMin][yMax][zMin] == -1) {
            grid[xMin][yMax][zMin] = getClosestNode(xMin, yMax, zMin);
        }
        if (grid[xMin][yMax][zMax] == -1) {
            grid[xMin][yMax][zMax] = getClosestNode(xMin, yMax, zMax);
        }
        if (grid[xMax][yMin][zMin] == -1) {
            grid[xMax][yMin][zMin] = getClosestNode(xMax, yMin, zMin);
        }
        if (grid[xMax][yMin][zMax] == -1) {
            grid[xMax][yMin][zMax] = getClosestNode(xMax, yMin, zMax);
        }
        if (grid[xMax][yMax][zMin] == -1) {
            grid[xMax][yMax][zMin] = getClosestNode(xMax, yMax, zMin);
        }
        if (grid[xMax][yMax][zMax] == -1) {
            grid[xMax][yMax][zMax] = getClosestNode(xMax, yMax, zMax);
        }

        if (grid[xMin][yMin][zMin] == grid[xMin][yMin][zMax] && grid[xMin][yMin][zMin] == grid[xMin][yMax][zMin] &&
                grid[xMin][yMin][zMin] == grid[xMin][yMax][zMax] && grid[xMin][yMin][zMin] == grid[xMax][yMin][zMin]
                && grid[xMin][yMin][zMin] == grid[xMax][yMin][zMax] && grid[xMin][yMin][zMin] == grid[xMax][yMax][zMin]
                && grid[xMin][yMin][zMin] == grid[xMax][yMax][zMax]) {
            int value = grid[xMin][yMin][zMin];
            for (int i = xMin; i <= xMax; i++) {
                for (int j = yMin; j <= yMax; j++) {
                    for (int k = zMin; k <= zMax; k++) {
                        grid[i][j][k] = value;
                    }
                }
            }
        }
        else if (xHalfLength == 1 && yHalfLength == 1 && zHalfLength == 1) {
            if (xLength != 2 || yLength != 2 || zLength != 2) {
                for (int i = xMin; i <= xMax; i++) {
                    for (int j = yMin; j <= yMax; j++) {
                        for (int k = zMin; k <= zMax; k++) {
                            if (grid[i][j][k] == -1) {
                                grid[i][j][k] = getClosestNode(i, j, k);
                            }
                        }
                    }
                }
                return;
            }
        }
        else if (xHalfLength == 1 && yHalfLength == 1 && zHalfLength > 1) {
            if (xLength == 3) {
                solve2DRoughCut(0, xMin, yMin, yMax, zMin, zMax);
                xMin++;
            }
            if (yLength == 3) {
                solve2DRoughCut(1, yMin, xMin, xMax, zMin, zMax);
                yMin++;
            }
            solve1D(2, xMin, yMin, zMin, zMidLow);
            solve1D(2, xMin, yMax, zMin, zMidLow);
            solve1D(2, xMax, yMin, zMin, zMidLow);
            solve1D(2, xMax, yMax, zMin, zMidLow);
            solve1D(2, xMin, yMin, zMidHigh, zMax);
            solve1D(2, xMin, yMax, zMidHigh, zMax);
            solve1D(2, xMax, yMin, zMidHigh, zMax);
            solve1D(2, xMax, yMax, zMidHigh, zMax);

        }
        else if (xHalfLength == 1 && yHalfLength > 1 && zHalfLength == 1) {
            if (xLength == 3) {
                solve2DRoughCut(0, xMin, yMin, yMax, zMin, zMax);
                xMin++;
            }
            if (zLength == 3) {
                solve2DRoughCut(2, zMin, xMin, xMax, yMin, yMax);
                zMin++;
            }
            solve1D(1, xMin, zMin, yMin, yMidLow);
            solve1D(1, xMin, zMax, yMin, yMidLow);
            solve1D(1, xMax, zMin, yMin, yMidLow);
            solve1D(1, xMax, zMax, yMin, yMidLow);
            solve1D(1, xMin, zMin, yMidHigh, yMax);
            solve1D(1, xMin, zMax, yMidHigh, yMax);
            solve1D(1, xMax, zMin, yMidHigh, yMax);
            solve1D(1, xMax, zMax, yMidHigh, yMax);
        }
        else if (xHalfLength > 1 && yHalfLength == 1 && zHalfLength == 1) {
            if (yLength == 3) {
                solve2DRoughCut(1, yMin, xMin, xMax, zMin, zMax);
                yMin++;
            }
            if (zLength == 3) {
                solve2DRoughCut(2, zMin, xMin, xMax, yMin, yMax);
                zMin++;
            }
            solve1D(0, yMin, zMin, xMin, xMidLow);
            solve1D(0, yMin, zMax, xMin, xMidLow);
            solve1D(0, yMax, zMin, xMin, xMidLow);
            solve1D(0, yMax, zMax, xMin, xMidLow);
            solve1D(0, yMin, zMin, xMidHigh, xMax);
            solve1D(0, yMin, zMax, xMidHigh, xMax);
            solve1D(0, yMax, zMin, xMidHigh, xMax);
            solve1D(0, yMax, zMax, xMidHigh, xMax);
        }
        else if (xHalfLength == 1 && yHalfLength > 1 && zHalfLength > 1) {
            if (xLength == 3) {
                solve2DRoughCut(0, xMin, yMin, yMax, zMin, zMax);
                xMin++;
            }
            solve2DRoughCut(0, xMin, yMin, yMidLow, zMin, zMidLow);
            solve2DRoughCut(0, xMin, yMin, yMidLow, zMidHigh, zMax);
            solve2DRoughCut(0, xMin, yMidHigh, yMax, zMin, zMidLow);
            solve2DRoughCut(0, xMin, yMidHigh, yMax, zMidHigh, zMax);
            solve2DRoughCut(0, xMax, yMin, yMidLow, zMin, zMidLow);
            solve2DRoughCut(0, xMax, yMin, yMidLow, zMidHigh, zMax);
            solve2DRoughCut(0, xMax, yMidHigh, yMax, zMin, zMidLow);
            solve2DRoughCut(0, xMax, yMidHigh, yMax, zMidHigh, zMax);
        }
        else if (yHalfLength == 1 && xHalfLength > 1 && zHalfLength > 1) {
            if (yLength == 3) {
                solve2DRoughCut(1, yMin, xMin, xMax, zMin, zMax);
                yMin++;
            }
            solve2DRoughCut(1, yMin, xMin, xMidLow, zMin, zMidLow);
            solve2DRoughCut(1, yMin, xMin, xMidLow, zMidHigh, zMax);
            solve2DRoughCut(1, yMin, xMidHigh, xMax, zMin, zMidLow);
            solve2DRoughCut(1, yMin, xMidHigh, xMax, zMidHigh, zMax);
            solve2DRoughCut(1, yMax, xMin, xMidLow, zMin, zMidLow);
            solve2DRoughCut(1, yMax, xMin, xMidLow, zMidHigh, zMax);
            solve2DRoughCut(1, yMax, xMidHigh, xMax, zMin, zMidLow);
            solve2DRoughCut(1, yMax, xMidHigh, xMax, zMidHigh, zMax);
        }
        else if (zHalfLength == 1 && yHalfLength > 1 && xHalfLength > 1) {
            if (zLength == 3) {
                solve2DRoughCut(2, zMin, xMin, xMax, yMin, yMax);
                zMin++;
            }
            solve2DRoughCut(2, zMin, xMin, xMidLow, yMin, yMidLow);
            solve2DRoughCut(2, zMin, xMin, xMidLow, yMidHigh, yMax);
            solve2DRoughCut(2, zMin, xMidHigh, xMax, yMin, yMidLow);
            solve2DRoughCut(2, zMin, xMidHigh, xMax, yMidHigh, yMax);
            solve2DRoughCut(2, zMax, xMin, xMidLow, yMin, yMidLow);
            solve2DRoughCut(2, zMax, xMin, xMidLow, yMidHigh, yMax);
            solve2DRoughCut(2, zMax, xMidHigh, xMax, yMin, yMidLow);
            solve2DRoughCut(2, zMax, xMidHigh, xMax, yMidHigh, yMax);
        }
        else {
            solveRoughCut(xMin, xMidLow, yMin, yMidLow, zMin, zMidLow);
            solveRoughCut(xMin, xMidLow, yMin, yMidLow, zMidHigh, zMax);
            solveRoughCut(xMin, xMidLow, yMidHigh, yMax, zMin, zMidLow);
            solveRoughCut(xMin, xMidLow, yMidHigh, yMax, zMidHigh, zMax);
            solveRoughCut(xMidHigh, xMax, yMin, yMidLow, zMin, zMidLow);
            solveRoughCut(xMidHigh, xMax, yMin, yMidLow, zMidHigh, zMax);
            solveRoughCut(xMidHigh, xMax, yMidHigh, yMax, zMin, zMidLow);
            solveRoughCut(xMidHigh, xMax, yMidHigh, yMax, zMidHigh, zMax);
        }
    }

    private void solve2DRoughCut(int flat_dimension, int slice, int xMin, int xMax, int yMin, int yMax) {
        int xLength = (xMax - xMin + 1);
        int yLength = (yMax - yMin + 1);
        int xHalfLength = xLength/2;
        int yHalfLength = yLength/2;
        int xOffset = xHalfLength - 1;
        int xMidLow = xMin + xOffset;
        if (xLength%2 == 1) {
            xMidLow++;
        }
        int xMidHigh = xMax - xOffset;
        int yOffset = yHalfLength - 1;
        int yMidLow = yMin + yOffset;
        if (yLength%2 == 1) {
            yMidLow++;
        }
        int yMidHigh = yMax - yOffset;
        switch(flat_dimension) {
            case 0: if (grid[slice][xMin][yMin] == -1) {
                grid[slice][xMin][yMin] = getClosestNode(slice, xMin, yMin);
            }
                if (grid[slice][xMin][yMax] == -1) {
                    grid[slice][xMin][yMax] = getClosestNode(slice, xMin, yMax);
                }
                if (grid[slice][xMax][yMin] == -1) {
                    grid[slice][xMax][yMin] = getClosestNode(slice, xMax, yMin);
                }
                if (grid[slice][xMax][yMax] == -1) {
                    grid[slice][xMax][yMax] = getClosestNode(slice, xMax, yMax);
                }
                if (grid[slice][xMin][yMin] == grid[slice][xMin][yMax]
                        && grid[slice][xMin][yMin] == grid[slice][xMax][yMin]
                        && grid[slice][xMin][yMin] == grid[slice][xMax][yMax]) {
                    int value = grid[slice][xMin][yMin];
                    for (int i = xMin; i <= xMax; i++) {
                        for (int j = yMin; j <= yMax; j++) {
                            grid[slice][i][j] = value;
                        }
                    }
                }
                else if (xHalfLength == 1 && yHalfLength == 1) {
                    if (xLength != 2 || yLength != 2) {
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                if (grid[slice][i][j] == -1)
                                    grid[slice][i][j] = getClosestNode(slice, i, j);
                            }
                        }
                    }
                    return;
                }
                else if (xHalfLength == 1 && yHalfLength > 1) {
                    if (xLength == 3) {
                        solve1D(2, slice, xMin, yMin, yMax);
                        xMin++;
                    }
                    solve1D(2, slice, xMin, yMin, yMidLow);
                    solve1D(2, slice, xMin, yMidHigh, yMax);
                    solve1D(2, slice, xMax, yMin, yMidLow);
                    solve1D(2, slice, xMax, yMidHigh, yMax);
                }
                else if (yHalfLength == 1 && xHalfLength > 1) {
                    if (yLength == 3) {
                        solve1D(1, slice, yMin, xMin, xMax);
                        yMin++;
                    }
                    solve1D(1, slice, yMin, xMin, xMidLow);
                    solve1D(1, slice, yMin, xMidHigh, xMax);
                    solve1D(1, slice, yMax, xMin, xMidLow);
                    solve1D(1, slice, yMax, xMidHigh, xMax);
                }
                else {
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMidHigh, yMax);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMidHigh, yMax);
                }
                break;
            case 1: if (grid[xMin][slice][yMin] == -1) {
                grid[xMin][slice][yMin] = getClosestNode(xMin, slice, yMin);
            }
                if (grid[xMin][slice][yMax] == -1) {
                    grid[xMin][slice][yMax] = getClosestNode(xMin, slice, yMax);
                }
                if (grid[xMax][slice][yMin] == -1) {
                    grid[xMax][slice][yMin] = getClosestNode(xMax, slice, yMin);
                }
                if (grid[xMax][slice][yMax] == -1) {
                    grid[xMax][slice][yMax] = getClosestNode(xMax, slice, yMax);
                }
                if (grid[xMin][slice][yMin] == grid[xMin][slice][yMax]
                        && grid[xMin][slice][yMin] == grid[xMax][slice][yMin]
                        && grid[xMin][slice][yMin] == grid[xMax][slice][yMax]) {
                    int value = grid[xMin][slice][yMin];
                    for (int i = xMin; i <= xMax; i++) {
                        for (int j = yMin; j <= yMax; j++) {
                            grid[i][slice][j] = value;
                        }
                    }
                }
                else if (xHalfLength == 1 && yHalfLength == 1) {
                    if (xLength != 2 || yLength != 2) {
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                if (grid[i][slice][j] == -1)
                                    grid[i][slice][j] = getClosestNode(i, slice, j);
                            }
                        }
                    }
                    return;
                }
                else if (xHalfLength == 1 && yHalfLength > 1) {
                    if (xLength == 3) {
                        solve1D(2, xMin, slice, yMin, yMax);
                        xMin++;
                    }
                    solve1D(2, xMin, slice, yMin, yMidLow);
                    solve1D(2, xMin, slice, yMidHigh, yMax);
                    solve1D(2, xMax, slice, yMin, yMidLow);
                    solve1D(2, xMax, slice, yMidHigh, yMax);
                }
                else if (yHalfLength == 1 && xHalfLength > 1) {
                    if (yLength == 3) {
                        solve1D(0, slice, yMin, xMin, xMax);
                        yMin++;
                    }
                    solve1D(0, slice, yMin, xMin, xMidLow);
                    solve1D(0, slice, yMin, xMidHigh, xMax);
                    solve1D(0, slice, yMax, xMin, xMidLow);
                    solve1D(0, slice, yMax, xMidHigh, xMax);
                }
                else {
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMidHigh, yMax);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMidHigh, yMax);
                }
                break;
            case 2: if (grid[xMin][yMin][slice] == -1) {
                grid[xMin][yMin][slice] = getClosestNode(xMin, yMin, slice);
            }
                if (grid[xMin][yMax][slice] == -1) {
                    grid[xMin][yMax][slice] = getClosestNode(xMin, yMax, slice);
                }
                if (grid[xMax][yMin][slice] == -1) {
                    grid[xMax][yMin][slice] = getClosestNode(xMax, yMin, slice);
                }
                if (grid[xMax][yMax][slice] == -1) {
                    grid[xMax][yMax][slice] = getClosestNode(xMax, yMax, slice);
                }
                if (grid[xMin][yMin][slice] == grid[xMin][yMax][slice]
                        && grid[xMin][yMin][slice] == grid[xMax][yMin][slice]
                        && grid[xMin][yMin][slice] == grid[xMax][yMax][slice]) {
                    int value = grid[xMin][yMin][slice];
                    for (int i = xMin; i <= xMax; i++) {
                        for (int j = yMin; j <= yMax; j++) {
                            grid[i][j][slice] = value;
                        }
                    }
                }
                else if (xHalfLength == 1 && yHalfLength == 1) {
                    if (xLength != 2 || yLength != 2) {
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                if (grid[i][j][slice] == -1)
                                    grid[i][j][slice] = getClosestNode(i, j, slice);
                            }
                        }
                    }
                    return;
                }
                else if (xHalfLength == 1 && yHalfLength > 1) {
                    if (xLength == 3) {
                        solve1D(1, xMin, slice, yMin, yMax);
                        xMin++;
                    }
                    solve1D(1, xMin, slice, yMin, yMidLow);
                    solve1D(1, xMin, slice, yMidHigh, yMax);
                    solve1D(1, xMax, slice, yMin, yMidLow);
                    solve1D(1, xMax, slice, yMidHigh, yMax);
                }
                else if (yHalfLength == 1 && xHalfLength > 1) {
                    if (yLength == 3) {
                        solve1D(0, yMin, slice, xMin, xMax);
                        yMin++;
                    }
                    solve1D(0, yMin, slice, xMin, xMidLow);
                    solve1D(0, yMin, slice, xMidHigh, xMax);
                    solve1D(0, yMax, slice, xMin, xMidLow);
                    solve1D(0, yMax, slice, xMidHigh, xMax);
                }
                else {
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMin, xMidLow, yMidHigh, yMax);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMin, yMidLow);
                    solve2DRoughCut(flat_dimension, slice, xMidHigh, xMax, yMidHigh, yMax);
                }
                break;
        }
    }

    public void solve(int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {
        if ((xMax - xMin + 1)%2 == 0 && (yMax - yMin + 1)%2 == 0 && (zMax - zMin + 1)%2 == 0) {
            solveEven(xMin, xMax, yMin, yMax, zMin, zMax);
        }
        else {
            solveOdd(xMin, xMax, yMin, yMax, zMin, zMax);
        }
    }

    private void solveOdd(int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {
        if ((xMax - xMin + 1)%2 != 0) {
            solve2D(0, xMin, yMin, yMax, zMin, zMax);
            xMin++;
        }
        if ((yMax - yMin + 1)%2 != 0) {
            solve2D(1, yMin, xMin, xMax, zMin, zMax);
            yMin++;
        }
        if ((zMax - zMin + 1)%2 != 0) {
            solve2D(2, zMin, xMin, xMax, yMin, yMax);
            zMin++;
        }
        solveEven(xMin, xMax, yMin, yMax, zMin, zMax);
    }

    private void solveEven(int xMin, int xMax, int yMin, int yMax, int zMin, int zMax) {
        int xHalfLength = (xMax - xMin + 1)/2;
        int yHalfLength = (yMax - yMin + 1)/2;
        int zHalfLength = (zMax - zMin + 1)/2;
        int xOffset = xHalfLength - 1;
        int yOffset = yHalfLength - 1;
        int zOffset = zHalfLength - 1;
        if (grid[xMin][yMin][zMin] == -1) {
            grid[xMin][yMin][zMin] = getClosestNode(xMin, yMin, zMin);
        }
        if (grid[xMin][yMin][zMax] == -1) {
            grid[xMin][yMin][zMax] = getClosestNode(xMin, yMin, zMax);
        }
        if (grid[xMin][yMax][zMin] == -1) {
            grid[xMin][yMax][zMin] = getClosestNode(xMin, yMax, zMin);
        }
        if (grid[xMin][yMax][zMax] == -1) {
            grid[xMin][yMax][zMax] = getClosestNode(xMin, yMax, zMax);
        }
        if (grid[xMax][yMin][zMin] == -1) {
            grid[xMax][yMin][zMin] = getClosestNode(xMax, yMin, zMin);
        }
        if (grid[xMax][yMin][zMax] == -1) {
            grid[xMax][yMin][zMax] = getClosestNode(xMax, yMin, zMax);
        }
        if (grid[xMax][yMax][zMin] == -1) {
            grid[xMax][yMax][zMin] = getClosestNode(xMax, yMax, zMin);
        }
        if (grid[xMax][yMax][zMax] == -1) {
            grid[xMax][yMax][zMax] = getClosestNode(xMax, yMax, zMax);
        }

        if (grid[xMin][yMin][zMin] == grid[xMin][yMin][zMax] && grid[xMin][yMin][zMin] == grid[xMin][yMax][zMin] &&
                grid[xMin][yMin][zMin] == grid[xMin][yMax][zMax] && grid[xMin][yMin][zMin] == grid[xMax][yMin][zMin]
                && grid[xMin][yMin][zMin] == grid[xMax][yMin][zMax] && grid[xMin][yMin][zMin] == grid[xMax][yMax][zMin]
                && grid[xMin][yMin][zMin] == grid[xMax][yMax][zMax]) {
            int value = grid[xMin][yMin][zMin];
            for (int i = xMin; i <= xMax; i++) {
                for (int j = yMin; j <= yMax; j++) {
                    for (int k = zMin; k <= zMax; k++) {
                        grid[i][j][k] = value;
                    }
                }
            }
        }
        else if (xHalfLength == 1 && yHalfLength == 1 && zHalfLength == 1) {
            return;
        }
        else if (xHalfLength == 1 && yHalfLength == 1 && zHalfLength > 1) {
            solve1D(2, xMin, yMin, zMin, zMin + zOffset);
            solve1D(2, xMin, yMax, zMin, zMin + zOffset);
            solve1D(2, xMax, yMin, zMin, zMin + zOffset);
            solve1D(2, xMax, yMax, zMin, zMin + zOffset);
            solve1D(2, xMin, yMin, zMax - zOffset, zMax);
            solve1D(2, xMin, yMax, zMax - zOffset, zMax);
            solve1D(2, xMax, yMin, zMax - zOffset, zMax);
            solve1D(2, xMax, yMax, zMax - zOffset, zMax);
        }
        else if (xHalfLength == 1 && yHalfLength > 1 && zHalfLength == 1) {
            solve1D(1, xMin, zMin, yMin, yMin + yOffset);
            solve1D(1, xMin, zMax, yMin, yMin + yOffset);
            solve1D(1, xMax, zMin, yMin, yMin + yOffset);
            solve1D(1, xMax, zMax, yMin, yMin + yOffset);
            solve1D(1, xMin, zMin, yMax - yOffset, yMax);
            solve1D(1, xMin, zMax, yMax - yOffset, yMax);
            solve1D(1, xMax, zMin, yMax - yOffset, yMax);
            solve1D(1, xMax, zMax, yMax - yOffset, yMax);
        }
        else if (xHalfLength > 1 && yHalfLength == 1 && zHalfLength == 1) {
            solve1D(0, yMin, zMin, xMin, xMin + xOffset);
            solve1D(0, yMin, zMax, xMin, xMin + xOffset);
            solve1D(0, yMax, zMin, xMin, xMin + xOffset);
            solve1D(0, yMax, zMax, xMin, xMin + xOffset);
            solve1D(0, yMin, zMin, xMax - xOffset, xMax);
            solve1D(0, yMin, zMax, xMax - xOffset, xMax);
            solve1D(0, yMax, zMin, xMax - xOffset, xMax);
            solve1D(0, yMax, zMax, xMax - xOffset, xMax);
        }
        else if (xHalfLength == 1 && yHalfLength > 1 && zHalfLength > 1) {
            solve2D(0, xMin, yMin, yMin + yOffset, zMin, zMin + zOffset);
            solve2D(0, xMin, yMin, yMin + yOffset, zMax - zOffset, zMax);
            solve2D(0, xMin, yMax - yOffset, yMax, zMin, zMin + zOffset);
            solve2D(0, xMin, yMax - yOffset, yMax, zMax - zOffset, zMax);
            solve2D(0, xMax, yMin, yMin + yOffset, zMin, zMin + zOffset);
            solve2D(0, xMax, yMin, yMin + yOffset, zMax - zOffset, zMax);
            solve2D(0, xMax, yMax - yOffset, yMax, zMin, zMin + zOffset);
            solve2D(0, xMax, yMax - yOffset, yMax, zMax - zOffset, zMax);
        }
        else if (yHalfLength == 1 && xHalfLength > 1 && zHalfLength > 1) {
            solve2D(1, yMin, xMin, xMin + xOffset, zMin, zMin + zOffset);
            solve2D(1, yMin, xMin, xMin + xOffset, zMax - zOffset, zMax);
            solve2D(1, yMin, xMax - xOffset, xMax, zMin, zMin + zOffset);
            solve2D(1, yMin, xMax - xOffset, xMax, zMax - zOffset, zMax);
            solve2D(1, yMax, xMin, xMin + xOffset, zMin, zMin + zOffset);
            solve2D(1, yMax, xMin, xMin + xOffset, zMax - zOffset, zMax);
            solve2D(1, yMax, xMax - xOffset, xMax, zMin, zMin + zOffset);
            solve2D(1, yMax, xMax - xOffset, xMax, zMax - zOffset, zMax);
        }
        else if (zHalfLength == 1 && yHalfLength > 1 && xHalfLength > 1) {
            solve2D(2, zMin, xMin, xMin + xOffset, yMin, yMin + yOffset);
            solve2D(2, zMin, xMin, xMin + xOffset, yMax - yOffset, yMax);
            solve2D(2, zMin, xMax - xOffset, xMax, yMin, yMin + yOffset);
            solve2D(2, zMin, xMax - xOffset, xMax, yMax - yOffset, yMax);
            solve2D(2, zMax, xMin, xMin + xOffset, yMin, yMin + yOffset);
            solve2D(2, zMax, xMin, xMin + xOffset, yMax - yOffset, yMax);
            solve2D(2, zMax, xMax - xOffset, xMax, yMin, yMin + yOffset);
            solve2D(2, zMax, xMax - xOffset, xMax, yMax - yOffset, yMax);
        }
        else {
            solve(xMin, xMin + xOffset, yMin, yMin + yOffset, zMin, zMin + zOffset);
            solve(xMin, xMin + xOffset, yMin, yMin + yOffset, zMax - zOffset, zMax);
            solve(xMin, xMin + xOffset, yMax - yOffset, yMax, zMin, zMin + zOffset);
            solve(xMin, xMin + xOffset, yMax - yOffset, yMax, zMax - zOffset, zMax);
            solve(xMax - xOffset, xMax, yMin, yMin + yOffset, zMin, zMin + zOffset);
            solve(xMax - xOffset, xMax, yMin, yMin + yOffset, zMax - zOffset, zMax);
            solve(xMax - xOffset, xMax, yMax - yOffset, yMax, zMin, zMin + zOffset);
            solve(xMax - xOffset, xMax, yMax - yOffset, yMax, zMax - zOffset, zMax);
        }
    }

    private void solve2D(int flat_dimension, int slice, int xMin, int xMax, int yMin, int yMax) {
        if ((xMax - xMin + 1)%2 == 0 && (yMax - yMin + 1)%2 == 0) {
            solve2DEven(flat_dimension, slice, xMin, xMax, yMin, yMax);
        }
        else {
            solve2DOdd(flat_dimension, slice, xMin, xMax, yMin, yMax);
        }
    }

    private void solve2DOdd(int flat_dimension, int slice, int xMin, int xMax, int yMin, int yMax) {
        if ((xMax - xMin + 1)%2 != 0) {
            switch(flat_dimension) {
                case 0: solve1D(2, slice, xMin, yMin, yMax);
                        break;
                case 1: solve1D(2, xMin, slice, yMin, yMax);
                        break;
                case 2: solve1D(1, xMin, slice, yMin, yMax);
                        break;
            }
            xMin++;
        }
        if ((yMax - yMin + 1)%2 != 0) {
            switch(flat_dimension) {
                case 0: solve1D(1, slice, yMin, xMin, xMax);
                        break;
                case 1: solve1D(0, slice, yMin, xMin, xMax);
                        break;
                case 2: solve1D(0, yMin, slice, xMin, xMax);
                        break;
            }
            yMin++;
        }
        solve2DEven(flat_dimension, slice, xMin, xMax, yMin, yMax);
    }

    private void solve2DEven(int flat_dimension, int slice, int xMin, int xMax, int yMin, int yMax) {
        int xHalfLength = (xMax - xMin + 1)/2;
        int yHalfLength = (yMax - yMin + 1)/2;
        int xOffset = xHalfLength - 1;
        int yOffset = yHalfLength - 1;
        switch(flat_dimension) {
            case 0: if (grid[slice][xMin][yMin] == -1) {
                    grid[slice][xMin][yMin] = getClosestNode(slice, xMin, yMin);
                    }
                    if (grid[slice][xMin][yMax] == -1) {
                        grid[slice][xMin][yMax] = getClosestNode(slice, xMin, yMax);
                    }
                    if (grid[slice][xMax][yMin] == -1) {
                        grid[slice][xMax][yMin] = getClosestNode(slice, xMax, yMin);
                    }
                    if (grid[slice][xMax][yMax] == -1) {
                        grid[slice][xMax][yMax] = getClosestNode(slice, xMax, yMax);
                    }
                    if (grid[slice][xMin][yMin] == grid[slice][xMin][yMax]
                            && grid[slice][xMin][yMin] == grid[slice][xMax][yMin]
                            && grid[slice][xMin][yMin] == grid[slice][xMax][yMax]) {
                        int value = grid[slice][xMin][yMin];
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                grid[slice][i][j] = value;
                            }
                        }
                    }
                    else if (xHalfLength == 1 && yHalfLength == 1) {
                        return;
                    }
                    else if (xHalfLength == 1 && yHalfLength > 1) {
                        solve1D(2, slice, xMin, yMin, yMin + yOffset);
                        solve1D(2, slice, xMin, yMax - yOffset, yMax);
                        solve1D(2, slice, xMax, yMin, yMin + yOffset);
                        solve1D(2, slice, xMax, yMax - yOffset, yMax);
                    }
                    else if (yHalfLength == 1 && xHalfLength > 1) {
                        solve1D(1, slice, yMin, xMin, xMin + xOffset);
                        solve1D(1, slice, yMin, xMax - xOffset, xMax);
                        solve1D(1, slice, yMax, xMin, xMin + xOffset);
                        solve1D(1, slice, yMax, xMax - xOffset, xMax);
                    }
                    else {
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMax - yOffset, yMax);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMax - yOffset, yMax);
                    }
                    break;
            case 1: if (grid[xMin][slice][yMin] == -1) {
                        grid[xMin][slice][yMin] = getClosestNode(xMin, slice, yMin);
                    }
                    if (grid[xMin][slice][yMax] == -1) {
                        grid[xMin][slice][yMax] = getClosestNode(xMin, slice, yMax);
                    }
                    if (grid[xMax][slice][yMin] == -1) {
                        grid[xMax][slice][yMin] = getClosestNode(xMax, slice, yMin);
                    }
                    if (grid[xMax][slice][yMax] == -1) {
                        grid[xMax][slice][yMax] = getClosestNode(xMax, slice, yMax);
                    }
                    if (grid[xMin][slice][yMin] == grid[xMin][slice][yMax]
                            && grid[xMin][slice][yMin] == grid[xMax][slice][yMin]
                            && grid[xMin][slice][yMin] == grid[xMax][slice][yMax]) {
                        int value = grid[xMin][slice][yMin];
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                grid[i][slice][j] = value;
                            }
                        }
                    }
                    else if (xHalfLength == 1 && yHalfLength == 1) {
                        return;
                    }
                    else if (xHalfLength == 1 && yHalfLength > 1) {
                        solve1D(2, xMin, slice, yMin, yMin + yOffset);
                        solve1D(2, xMin, slice, yMax - yOffset, yMax);
                        solve1D(2, xMax, slice, yMin, yMin + yOffset);
                        solve1D(2, xMax, slice, yMax - yOffset, yMax);
                    }
                    else if (yHalfLength == 1 && xHalfLength > 1) {
                        solve1D(0, slice, yMin, xMin, xMin + xOffset);
                        solve1D(0, slice, yMin, xMax - xOffset, xMax);
                        solve1D(0, slice, yMax, xMin, xMin + xOffset);
                        solve1D(0, slice, yMax, xMax - xOffset, xMax);
                    }
                    else {
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMax - yOffset, yMax);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMax - yOffset, yMax);
                    }
                    break;
            case 2: if (grid[xMin][yMin][slice] == -1) {
                        grid[xMin][yMin][slice] = getClosestNode(xMin, yMin, slice);
                    }
                    if (grid[xMin][yMax][slice] == -1) {
                        grid[xMin][yMax][slice] = getClosestNode(xMin, yMax, slice);
                    }
                    if (grid[xMax][yMin][slice] == -1) {
                        grid[xMax][yMin][slice] = getClosestNode(xMax, yMin, slice);
                    }
                    if (grid[xMax][yMax][slice] == -1) {
                        grid[xMax][yMax][slice] = getClosestNode(xMax, yMax, slice);
                    }
                    if (grid[xMin][yMin][slice] == grid[xMin][yMax][slice]
                            && grid[xMin][yMin][slice] == grid[xMax][yMin][slice]
                            && grid[xMin][yMin][slice] == grid[xMax][yMax][slice]) {
                        int value = grid[xMin][yMin][slice];
                        for (int i = xMin; i <= xMax; i++) {
                            for (int j = yMin; j <= yMax; j++) {
                                grid[i][j][slice] = value;
                            }
                        }
                    }
                    else if (xHalfLength == 1 && yHalfLength == 1) {
                        return;
                    }
                    else if (xHalfLength == 1 && yHalfLength > 1) {
                        solve1D(1, xMin, slice, yMin, yMin + yOffset);
                        solve1D(1, xMin, slice, yMax - yOffset, yMax);
                        solve1D(1, xMax, slice, yMin, yMin + yOffset);
                        solve1D(1, xMax, slice, yMax - yOffset, yMax);
                    }
                    else if (yHalfLength == 1 && xHalfLength > 1) {
                        solve1D(0, yMin, slice, xMin, xMin + xOffset);
                        solve1D(0, yMin, slice, xMax - xOffset, xMax);
                        solve1D(0, yMax, slice, xMin, xMin + xOffset);
                        solve1D(0, yMax, slice, xMax - xOffset, xMax);
                    }
                    else {
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMin, xMin + xOffset, yMax - yOffset, yMax);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMin, yMin + yOffset);
                        solve2D(flat_dimension, slice, xMax - xOffset, xMax, yMax - yOffset, yMax);
                    }
                    break;
        }
    }

    private void solve1D(int variable_dimension, int slice1, int slice2, int xMin, int xMax) {
        if ((xMax - xMin + 1)%2 != 0) {
            switch(variable_dimension) {
                case 0: grid[xMin][slice1][slice2] = getClosestNode(xMin, slice1, slice2);
                        break;
                case 1: grid[slice1][xMin][slice2] = getClosestNode(slice1, xMin, slice2);
                        break;
                case 2: grid[slice1][slice2][xMin] = getClosestNode(slice1, slice2, xMin);
                        break;
            }
            xMin++;
        }
        int xHalfLength = (xMax - xMin + 1)/2;
        int xOffset = xHalfLength - 1;
        switch(variable_dimension) {
            case 0: if (grid[xMin][slice1][slice2] == -1) {
                        grid[xMin][slice1][slice2] = getClosestNode(xMin, slice1, slice2);
                    }
                    if (grid[xMax][slice1][slice2] == -1) {
                        grid[xMax][slice1][slice2] = getClosestNode(xMax, slice1, slice2);
                    }
                    if (grid[xMin][slice1][slice2] == grid[xMax][slice1][slice2]) {
                        for (int i = xMin; i <= xMax; i++) {
                            grid[i][slice1][slice2] = grid[xMin][slice1][slice2];
                        }
                    }
                    else if(xHalfLength == 1) {
                        return;
                    }
                    else {
                        solve1D(variable_dimension, slice1, slice2, xMin, xMin + xOffset);
                        solve1D(variable_dimension, slice1, slice2, xMax - xOffset, xMax);
                    }
                    break;
            case 1: if (grid[slice1][xMin][slice2] == -1) {
                        grid[slice1][xMin][slice2] = getClosestNode(slice1, xMin, slice2);
                    }
                    if (grid[slice1][xMax][slice2] == -1) {
                        grid[slice1][xMax][slice2] = getClosestNode(slice1, xMax, slice2);
                    }
                    if (grid[slice1][xMin][slice2] == grid[slice1][xMax][slice2]) {
                        for (int i = xMin; i <= xMax; i++) {
                            grid[slice1][i][slice2] = grid[slice1][xMin][slice2];
                        }
                    }
                    else if(xHalfLength == 1) {
                        return;
                    }
                    else {
                        solve1D(variable_dimension, slice1, slice2, xMin, xMin + xOffset);
                        solve1D(variable_dimension, slice1, slice2, xMax - xOffset, xMax);
                    }
                    break;
            case 2: if (grid[slice1][slice2][xMin] == -1) {
                        grid[slice1][slice2][xMin] = getClosestNode(slice1, slice2, xMin);
                    }
                    if (grid[slice1][slice2][xMax] == -1) {
                        grid[slice1][slice2][xMax] = getClosestNode(slice1, slice2, xMax);
                    }
                    if (grid[slice1][slice2][xMin] == grid[slice1][slice2][xMax]) {
                        for (int i = xMin; i <= xMax; i++) {
                            grid[slice1][slice2][i] = grid[slice1][slice2][xMin];
                        }
                    }
                    else if(xHalfLength == 1) {
                        return;
                    }
                    else {
                        solve1D(variable_dimension, slice1, slice2, xMin, xMin + xOffset);
                        solve1D(variable_dimension, slice1, slice2, xMax - xOffset, xMax);
                    }
                    break;
        }
    }

    public String print() {
        String result = "";
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    result += "" + grid[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        return result;
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
