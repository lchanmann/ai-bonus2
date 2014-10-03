package ai.core;

public class Node {
    
    private char[] state;
    private Node parent;
    private Action action;
    private int pathCost;
    
    public Node(char[] state) {
        this(state, null);
    }
    
    public Node(char[] state, Node parent) {
        this.state = state;
        this.parent = parent;
        this.pathCost = parent == null ? 0 : parent.pathCost + 1;
    }

    public char[] getState() {
        return state;
    }
    
    public int getPathCost() {
        return pathCost;
    }

    public boolean equals(Object obj) {
        Node other = (Node) obj;
        char[] otherState = other.getState();

        for (int i=0; i<state.length; i++) {
            if (state[i] != otherState[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (int i=0; i<state.length; i++) {
            if (state[i] != Puzzle.BLANK) {
                result += Integer.valueOf(state[i]) * Math.pow(10, i);
            }
        }
        return result;
    }
}
