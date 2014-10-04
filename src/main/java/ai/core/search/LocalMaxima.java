package ai.core.search;

import ai.core.Node;
import ai.core.Puzzle;

public class LocalMaxima extends SearchResult {

    private Node node;

    public LocalMaxima(Node node, int expanded, long executionTime) {
        this.node = node;
        this.cost = node.getPathCost();
        this.expanded = expanded;
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ Solution cost: ")
          .append(cost).append(", ")
          .append("Expanded nodes: ")
          .append(expanded).append(", ")
          .append("Execution time: ")
          .append(getExecutionTimeInSecond()).append("(s) ]")
          .append("\n")
          .append("(No better neighbor found).");
        return sb.toString();
    }
}
