package ai.core.impl;

import ai.core.Result;

public class Solution implements Result{

    private int cost;
    private int expanded;
    private long executionTime;

    public Solution(int cost, int expanded, long executionTime) {
        this.cost = cost;
        this.expanded = expanded;
        this.executionTime = executionTime;
    }

    private double getExecutionTimeInSecond() {
        return executionTime / Math.pow(10, 6);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ Solution cost: ")
          .append(cost).append(", ")
          .append("Expanded nodes: ")
          .append(expanded).append(", ")
          .append("Execution time: ")
          .append(getExecutionTimeInSecond()).append("(s) ]");
        return sb.toString();
    }
}
