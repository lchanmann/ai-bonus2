package ai.core.search;


public class Solution extends SearchResult{

    public Solution(int cost, int expanded, long executionTime) {
        this.cost = cost;
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
          .append(getExecutionTimeInSecond()).append("(s) ]");
        return sb.toString();
    }
}
