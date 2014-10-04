package ai.core.search;


public class Failure extends SearchResult {

    private String reason;

    public Failure(String reason) {
        this.reason = reason;
        this.cost = Short.MAX_VALUE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ")
          .append("Cost: ").append(cost).append(", ")
          .append("Reason: ").append(reason)
          .append(" ]");
        return sb.toString();
    }
}
