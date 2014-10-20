package ai.core.search;

import ai.core.Node;
import ai.util.Helper;

public class Solution implements ISearchResult {

    private Node node;
    private int expanded;
    private long executionTime;

    private static final Helper helper = Helper.getInstance();

    public Solution(Node node, int expanded, Long executionTime) {
        this.node = node;
        this.expanded = expanded;
        this.executionTime = executionTime;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ Solution cost: ")
          .append(node.getPathCost()).append(", ")
          .append("Expanded nodes: ")
          .append(expanded).append(", ")
          .append("Execution time: ")
          .append(helper.nanoSecondsToSeconds(executionTime)).append("(s) ]");
        return sb.toString();
    }
}
