package ai.core;

public class Node {
    
    private char[] state;
    private Node parent;
    private Action action;
    private int pathCost;
    
    public Node(char[] state) {
        this(state, null, null);
    }
    
    public Node(char[] state, Node parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = parent == null ? 0 : parent.pathCost + 1;
    }

    public char[] getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
    
    public int getPathCost() {
        return pathCost;
    }
    
    public Action getAction() {
        return action;
    }

    @Override
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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("state: { ");
//        for(char c : state) {
//            sb.append(c).append(" ");
//        }
//        return sb.append("}").toString();
//    }
}
