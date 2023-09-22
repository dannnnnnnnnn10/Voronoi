package VoronoiTree;

public class Node {

    private int[] vars;

    public Node(int[] vars) {
        this.vars = vars;
    }

    public int[] getVars() {
        return vars;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i + 1 < vars.length; i ++) {
            result += vars[i] + ", ";
        }
        result += vars[vars.length - 1] + "\n";
        return result;
    }
}
