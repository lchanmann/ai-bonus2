package ai.core;

public interface Heuristic {

    /**
     * Evaluate heuristic function
     * @param state
     * @return result
     */
    int evaluate(char[] state);
}
