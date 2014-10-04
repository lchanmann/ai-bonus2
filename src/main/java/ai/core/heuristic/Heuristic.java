package ai.core.heuristic;

public interface Heuristic {

    /**
     * Evaluate heuristic function
     * @param state
     * @return result
     */
    public int evaluate(char[] state);
}
