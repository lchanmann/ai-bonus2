package ai.core.search;

public abstract class SearchResult {

    protected int cost;
    protected int expanded;
    protected long executionTime;

    public int getCost() {
        return cost;
    }

    public double getExecutionTimeInSecond() {
        return executionTime / Math.pow(10, 6);
    }
}
