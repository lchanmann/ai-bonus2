package ai.core.impl;

import ai.core.Result;

public class Solution implements Result{

    private int cost;
    private int expanded;

    public Solution(int cost, int expanded) {
        this.cost = cost;
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ Solution cost: ")
          .append(cost).append(", ")
          .append("Expanded nodes: ")
          .append(expanded).append(" ]");
        return sb.toString();
    }
}
