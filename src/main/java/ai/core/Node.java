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
}
