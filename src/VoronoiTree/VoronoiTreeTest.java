package VoronoiTree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoronoiTreeTest {

    @Test
    public void testOneNodeEven() {
        VoronoiTree test = new VoronoiTree(2, 2, 2);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(2, 2, 2);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(2, 2, 2);
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
        VoronoiTree test = new VoronoiTree(3, 2, 2);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(3, 2, 2);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(3, 2, 2);
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
        VoronoiTree test = new VoronoiTree(2, 3, 2);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(2, 3, 2);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(2, 3, 2);
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
        VoronoiTree test = new VoronoiTree(2, 2, 3);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(2, 2, 3);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(2, 2, 3);
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
        VoronoiTree test = new VoronoiTree(3, 3, 2);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(3, 3, 2);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(3, 3, 2);
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
        VoronoiTree test = new VoronoiTree(3, 2, 3);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(3, 2, 3);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(3, 2, 3);
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
        VoronoiTree test = new VoronoiTree(2, 3, 3);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(2, 3, 3);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(2, 3, 3);
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
        VoronoiTree test = new VoronoiTree(3, 3, 3);
        test.addNode(1, 1, 1);
        VoronoiTree test2 = new VoronoiTree(3, 3, 3);
        test2.addNode(1, 1, 1);
        VoronoiTree brute = new VoronoiTree(3, 3, 3);
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
        VoronoiTree test = new VoronoiTree(2, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 2, 2);
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
        VoronoiTree test = new VoronoiTree(3, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 2, 2);
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
        VoronoiTree test = new VoronoiTree(2, 3, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 3, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 3, 2);
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
        VoronoiTree test = new VoronoiTree(2, 2, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 2, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 2, 3);
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
        VoronoiTree test = new VoronoiTree(3, 3, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 3, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 3, 2);
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
        VoronoiTree test = new VoronoiTree(3, 2, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 2, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 2, 3);
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
        VoronoiTree test = new VoronoiTree(2, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 3, 3);
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
        VoronoiTree test = new VoronoiTree(3, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 3, 3);
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
        VoronoiTree test = new VoronoiTree(4, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 4, 4);
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
        VoronoiTree test = new VoronoiTree(5, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(5, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(5, 4, 4);
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
        VoronoiTree test = new VoronoiTree(4, 5, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 5, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 5, 4);
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
        VoronoiTree test = new VoronoiTree(4, 4, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 4, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 4, 5);
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
        VoronoiTree test = new VoronoiTree(5, 5, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(5, 5, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(5, 5, 4);
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
        VoronoiTree test = new VoronoiTree(5, 4, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(5, 4, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(5, 4, 5);
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
        VoronoiTree test = new VoronoiTree(4, 5, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 5, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 5, 5);
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
        VoronoiTree test = new VoronoiTree(5, 5, 5);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(5, 5, 5);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(5, 5, 5);
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
        VoronoiTree test = new VoronoiTree(2, 6, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 6, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 6, 6);
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
        VoronoiTree test = new VoronoiTree(6, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 2, 6);
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
        VoronoiTree test = new VoronoiTree(6, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 6, 2);
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
        VoronoiTree test = new VoronoiTree(6, 2, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 2, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 2, 2);
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
        VoronoiTree test = new VoronoiTree(2, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 6, 2);
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
        VoronoiTree test = new VoronoiTree(2, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 2, 6);
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
        VoronoiTree test = new VoronoiTree(3, 6, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 6, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 6, 6);
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
        VoronoiTree test = new VoronoiTree(3, 4, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 4, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 4, 4);
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
        VoronoiTree test = new VoronoiTree(6, 3, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 3, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 3, 6);
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
        VoronoiTree test = new VoronoiTree(4, 3, 4);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 3, 4);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 3, 4);
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
        VoronoiTree test = new VoronoiTree(6, 6, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 6, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 6, 3);
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
        VoronoiTree test = new VoronoiTree(4, 4, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(4, 4, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(4, 4, 3);
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
        VoronoiTree test = new VoronoiTree(6, 3, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 3, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 3, 3);
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
        VoronoiTree test = new VoronoiTree(3, 6, 3);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 6, 3);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 6, 3);
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
        VoronoiTree test = new VoronoiTree(3, 3, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(3, 3, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(3, 3, 6);
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
        VoronoiTree test = new VoronoiTree(2, 6, 8);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 6, 8);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 6, 8);
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
        VoronoiTree test = new VoronoiTree(2, 8, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(2, 8, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(2, 8, 6);
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
        VoronoiTree test = new VoronoiTree(6, 2, 8);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 2, 8);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 2, 8);
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
        VoronoiTree test = new VoronoiTree(8, 2, 6);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(8, 2, 6);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(8, 2, 6);
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
        VoronoiTree test = new VoronoiTree(6, 8, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(6, 8, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(6, 8, 2);
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
        VoronoiTree test = new VoronoiTree(8, 6, 2);
        test.addNode(1, 1, 1);
        test.addNode(0, 0, 0);
        VoronoiTree test2 = new VoronoiTree(8, 6, 2);
        test2.addNode(1, 1, 1);
        test2.addNode(0, 0, 0);
        VoronoiTree brute = new VoronoiTree(8, 6, 2);
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
