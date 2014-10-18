package ai.core.search;

import java.util.AbstractMap.SimpleEntry;

import ai.core.Node;
import ai.util.Helper;

public class Solution implements ISearchResult {

    private Node node;
    private int expanded;
    private double executionTime;
    private long startTime;

    private final Helper helper = Helper.getInstance();

    public Solution() {
        this.startTime = System.nanoTime();
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
          .append(executionTime).append("(s) ]");
        return sb.toString();
    }

    public void updateResult(SimpleEntry<Node, Integer> result) {
        this.node = result.getKey();
        this.expanded = result.getValue();
        this.executionTime = helper.nanoSecondsToSeconds(System.nanoTime() - startTime);
    }
}
