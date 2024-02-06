package Voronoi3D;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoronoiTreeTest {

    @Test
    public void testOneNodeEven() {
        VoronoiTree test = new VoronoiTree(new int[]{2,2,2}, 1);
        test.addNode(new int[]{1,1,1});
        Voronoi3D brute = new Voronoi3D(2, 2, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][2][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddX() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 2, 2}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(3, 2, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][2][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddY() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 3, 2}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(2, 3, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][3][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddZ() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 2, 3}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(2, 2, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][2][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddXY() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 3, 2}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(3, 3, 2);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][3][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddXZ() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 2, 3}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(3, 2, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][2][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddYZ() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 3, 3}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(2, 3, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][3][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testOneNodeOddXYZ() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 3, 3}, 1);
        test.addNode(new int[]{1, 1, 1});
        Voronoi3D brute = new Voronoi3D(3, 3, 3);
        brute.addNode(1, 1, 1);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][3][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesEven() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 2, 2}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][2][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddX() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 2, 2}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][2][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddY() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 3, 2}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 3, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][3][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddZ() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 2, 3}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 2, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][2][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddXY() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 3, 2}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 3, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][3][2];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddXZ() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 2, 3}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 2, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][2][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddYZ() {
        VoronoiTree test = new VoronoiTree(new int[]{2, 3, 3}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[2][3][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testBoundaryTwoNodesOddXYZ() {
        VoronoiTree test = new VoronoiTree(new int[]{3, 3, 3}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[3][3][3];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesEven() {
        int x = 4;
        int y = 4;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[4][4][4];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddX() {
        int x = 5;
        int y = 4;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(5, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddY() {
        int x = 4;
        int y = 5;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 5, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddZ() {
        int x = 4;
        int y = 4;
        int z = 5;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 4, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddXY() {
        int x = 5;
        int y = 5;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(5, 5, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddXZ() {
        int x = 5;
        int y = 4;
        int z = 5;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(5, 4, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddYZ() {
        int x = 4;
        int y = 5;
        int z = 5;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 5, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testTwoNodesOddXYZ() {
        int x = 5;
        int y = 5;
        int z = 5;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(5, 5, 5);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DSplitCaseX() {
        int x = 2;
        int y = 6;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 6, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DSplitCaseY() {
        int x = 6;
        int y = 2;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DSplitCaseZ() {
        int x = 6;
        int y = 6;
        int z = 2;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test1DSplitCaseX() {
        int x = 6;
        int y = 2;
        int z = 2;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 2, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test1DSplitCaseY() {
        int x = 2;
        int y = 6;
        int z = 2;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test1DSplitCaseZ() {
        int x = 2;
        int y = 2;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut2DSplitCaseX() {
        int x = 3;
        int y = 6;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 6, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }
    
    @Test
    public void testRoughCut2DSplitCaseXYandZLength4() {
        int x = 3;
        int y = 4;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 4, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut2DSplitCaseY() {
        int x = 6;
        int y = 3;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 3, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }
    
    @Test
    public void testRoughCut2DSplitCaseYXandZLength4() {
        int x = 4;
        int y = 3;
        int z = 4;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 3, 4);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut2DSplitCaseZ() {
        int x = 6;
        int y = 6;
        int z = 3;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 6, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }
    
    @Test
    public void testRoughCut2DSplitCaseZXandYLength4() {
        int x = 4;
        int y = 4;
        int z = 3;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(4, 4, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut1DSplitCaseX() {
        int x = 6;
        int y = 3;
        int z = 3;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 3, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut1DSplitCaseY() {
        int x = 3;
        int y = 6;
        int z = 3;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 6, 3);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void testRoughCut1DSplitCaseZ() {
        int x = 3;
        int y = 3;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(3, 3, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatXYis3() {
        int x = 2;
        int y = 6;
        int z = 8;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 6, 8);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatXZis3() {
        int x = 2;
        int y = 8;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(2, 8, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatYXis3() {
        int x = 6;
        int y = 2;
        int z = 8;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 2, 8);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatYZis3() {
        int x = 8;
        int y = 2;
        int z = 6;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(8, 2, 6);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatZXis3() {
        int x = 6;
        int y = 8;
        int z = 2;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(6, 8, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }

    @Test
    public void test2DRoughCutFlatZYis3() {
        int x = 8;
        int y = 6;
        int z = 2;
        VoronoiTree test = new VoronoiTree(new int[]{x, y, z}, 2);
        test.addNode(new int[]{1, 1, 1});
        test.addNode(new int[]{0, 0, 0});
        Voronoi3D brute = new Voronoi3D(8, 6, 2);
        brute.addNode(1, 1, 1);
        brute.addNode(0, 0, 0);
        brute.bruteForce();
        String s = brute.print();
        test.solve();
        String result = test.print();
        int[][][] array = new int[x][y][z];
        String[] results = result.split("\n");
        for (int i = 0; i < results.length; i++) {
            String[] line = results[i].replace("\n", "").split(",");
            for (int h = Integer.parseInt(line[0]); h <= Integer.parseInt(line[1]); h++) {
                for (int j = Integer.parseInt(line[2]); j <= Integer.parseInt(line[3]); j++) {
                    for (int k = Integer.parseInt(line[4]); k <= Integer.parseInt(line[5]); k++) {
                        array[h][j][k] = Integer.parseInt(line[6]);
                    }
                }
            }
        }
        result = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result += "" + array[i][j][k] + " ";
                }
                result += "\n";
            }
            result += "\n";
        }
        assertEquals(s, result);
    }


}
