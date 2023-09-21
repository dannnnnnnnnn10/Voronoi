package Voronoi3D;

import org.junit.Test;

import static org.junit.Assert.*;

public class Voronoi3DTest {

    @Test
    public void testOneNodeEven() {
        Voronoi3D test = new Voronoi3D(2, 2, 2);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(2, 2, 2);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(2, 2, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 1, 0, 1);
        test2.solve(0, 1, 0, 1, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddX() {
        Voronoi3D test = new Voronoi3D(3, 2, 2);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(3, 2, 2);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(3, 2, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 1, 0, 1);
        test2.solve(0, 2, 0, 1, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddY() {
        Voronoi3D test = new Voronoi3D(2, 3, 2);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(2, 3, 2);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(2, 3, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 2, 0, 1);
        test2.solve(0, 1, 0, 2, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddZ() {
        Voronoi3D test = new Voronoi3D(2, 2, 3);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(2, 2, 3);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(2, 2, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 1, 0, 2);
        test2.solve(0, 1, 0, 1, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddXY() {
        Voronoi3D test = new Voronoi3D(3, 3, 2);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(3, 3, 2);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(3, 3, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 2, 0, 1);
        test2.solve(0, 2, 0, 2, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddXZ() {
        Voronoi3D test = new Voronoi3D(3, 2, 3);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(3, 2, 3);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(3, 2, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 1, 0, 2);
        test2.solve(0, 2, 0, 1, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddYZ() {
        Voronoi3D test = new Voronoi3D(2, 3, 3);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(2, 3, 3);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(2, 3, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 2, 0, 2);
        test2.solve(0, 1, 0, 2, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testOneNodeOddXYZ() {
        Voronoi3D test = new Voronoi3D(3, 3, 3);
        test.addNode(1, 1, 1);
        Voronoi3D test2 = new Voronoi3D(3, 3, 3);
        test2.addNode(1, 1, 1);
        Voronoi3D brute = new Voronoi3D(3, 3, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 2, 0, 2);
        test2.solve(0, 2, 0, 2, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesEven() {
        Voronoi3D test = new Voronoi3D(2, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 1, 0, 1);
        test2.solve(0, 1, 0, 1, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddX() {
        Voronoi3D test = new Voronoi3D(3, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 1, 0, 1);
        test2.solve(0, 2, 0, 1, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddY() {
        Voronoi3D test = new Voronoi3D(2, 3, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 3, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 3, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 2, 0, 1);
        test2.solve(0, 1, 0, 2, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddZ() {
        Voronoi3D test = new Voronoi3D(2, 2, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 2, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 2, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 1, 0, 2);
        test2.solve(0, 1, 0, 1, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddXY() {
        Voronoi3D test = new Voronoi3D(3, 3, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 3, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 3, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 2, 0, 1);
        test2.solve(0, 2, 0, 2, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddXZ() {
        Voronoi3D test = new Voronoi3D(3, 2, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 2, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 2, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 1, 0, 2);
        test2.solve(0, 2, 0, 1, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddYZ() {
        Voronoi3D test = new Voronoi3D(2, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 2, 0, 2);
        test2.solve(0, 1, 0, 2, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testBoundaryTwoNodesOddXYZ() {
        Voronoi3D test = new Voronoi3D(3, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 2, 0, 2);
        test2.solve(0, 2, 0, 2, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesEven() {
        Voronoi3D test = new Voronoi3D(4, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 3, 0, 3);
        test2.solve(0, 3, 0, 3, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddX() {
        Voronoi3D test = new Voronoi3D(5, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(5, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(5, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 4, 0, 3, 0, 3);
        test2.solve(0, 4, 0, 3, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddY() {
        Voronoi3D test = new Voronoi3D(4, 5, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 5, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 5, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 4, 0, 3);
        test2.solve(0, 3, 0, 4, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddZ() {
        Voronoi3D test = new Voronoi3D(4, 4, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 4, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 4, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 3, 0, 4);
        test2.solve(0, 3, 0, 3, 0, 4);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddXY() {
        Voronoi3D test = new Voronoi3D(5, 5, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(5, 5, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(5, 5, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 4, 0, 4, 0, 3);
        test2.solve(0, 4, 0, 4, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddXZ() {
        Voronoi3D test = new Voronoi3D(5, 4, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(5, 4, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(5, 4, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 4, 0, 3, 0, 4);
        test2.solve(0, 4, 0, 3, 0, 4);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddYZ() {
        Voronoi3D test = new Voronoi3D(4, 5, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 5, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 5, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 4, 0, 4);
        test2.solve(0, 3, 0, 4, 0, 4);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testTwoNodesOddXYZ() {
        Voronoi3D test = new Voronoi3D(5, 5, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(5, 5, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(5, 5, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 4, 0, 4, 0, 4);
        test2.solve(0, 4, 0, 4, 0, 4);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DSplitCaseX() {
        Voronoi3D test = new Voronoi3D(2, 6, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 6, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 6, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 5, 0, 5);
        test2.solve(0, 1, 0, 5, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DSplitCaseY() {
        Voronoi3D test = new Voronoi3D(6, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 1, 0, 5);
        test2.solve(0, 5, 0, 1, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DSplitCaseZ() {
        Voronoi3D test = new Voronoi3D(6, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 5, 0, 1);
        test2.solve(0, 5, 0, 5, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test1DSplitCaseX() {
        Voronoi3D test = new Voronoi3D(6, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 1, 0, 1);
        test2.solve(0, 5, 0, 1, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test1DSplitCaseY() {
        Voronoi3D test = new Voronoi3D(2, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 5, 0, 1);
        test2.solve(0, 1, 0, 5, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test1DSplitCaseZ() {
        Voronoi3D test = new Voronoi3D(2, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 1, 0, 5);
        test2.solve(0, 1, 0, 1, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut2DSplitCaseX() {
        Voronoi3D test = new Voronoi3D(3, 6, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 6, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 6, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 5, 0, 5);
        test2.solve(0, 2, 0, 5, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }
    
    @Test
    public void testRoughCut2DSplitCaseXYandZLength4() {
        Voronoi3D test = new Voronoi3D(3, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 3, 0, 3);
        test2.solve(0, 2, 0, 3, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut2DSplitCaseY() {
        Voronoi3D test = new Voronoi3D(6, 3, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 3, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 3, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 2, 0, 5);
        test2.solve(0, 5, 0, 2, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }
    
    @Test
    public void testRoughCut2DSplitCaseYXandZLength4() {
        Voronoi3D test = new Voronoi3D(4, 3, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 3, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 3, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 2, 0, 3);
        test2.solve(0, 3, 0, 2, 0, 3);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut2DSplitCaseZ() {
        Voronoi3D test = new Voronoi3D(6, 6, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 6, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 6, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 5, 0, 2);
        test2.solve(0, 5, 0, 5, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }
    
    @Test
    public void testRoughCut2DSplitCaseZXandYLength4() {
        Voronoi3D test = new Voronoi3D(4, 4, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(4, 4, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(4, 4, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 3, 0, 3, 0, 2);
        test2.solve(0, 3, 0, 3, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut1DSplitCaseX() {
        Voronoi3D test = new Voronoi3D(6, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 2, 0, 2);
        test2.solve(0, 5, 0, 2, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut1DSplitCaseY() {
        Voronoi3D test = new Voronoi3D(3, 6, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 6, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 6, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 5, 0, 2);
        test2.solve(0, 2, 0, 5, 0, 2);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void testRoughCut1DSplitCaseZ() {
        Voronoi3D test = new Voronoi3D(3, 3, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(3, 3, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(3, 3, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 2, 0, 2, 0, 5);
        test2.solve(0, 2, 0, 2, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatXYis3() {
        Voronoi3D test = new Voronoi3D(2, 6, 8);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 6, 8);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 6, 8);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 5, 0, 7);
        test2.solve(0, 1, 0, 5, 0, 7);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatXZis3() {
        Voronoi3D test = new Voronoi3D(2, 8, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(2, 8, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(2, 8, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 1, 0, 7, 0, 5);
        test2.solve(0, 1, 0, 7, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatYXis3() {
        Voronoi3D test = new Voronoi3D(6, 2, 8);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 2, 8);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 2, 8);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 1, 0, 7);
        test2.solve(0, 5, 0, 1, 0, 7);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatYZis3() {
        Voronoi3D test = new Voronoi3D(8, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(8, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(8, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 7, 0, 1, 0, 5);
        test2.solve(0, 7, 0, 1, 0, 5);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatZXis3() {
        Voronoi3D test = new Voronoi3D(6, 8, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(6, 8, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(6, 8, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 5, 0, 7, 0, 1);
        test2.solve(0, 5, 0, 7, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }

    @Test
    public void test2DRoughCutFlatZYis3() {
        Voronoi3D test = new Voronoi3D(8, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        Voronoi3D test2 = new Voronoi3D(8, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        Voronoi3D brute = new Voronoi3D(8, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solveRoughCut(0, 7, 0, 5, 0, 1);
        test2.solve(0, 7, 0, 5, 0, 1);
        assertEquals(test.print(), s);
        assertEquals(test2.print(), s);
    }


}
