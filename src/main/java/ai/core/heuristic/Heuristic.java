package ai.core.heuristic;

import ai.core.Node;

public interface Heuristic {

    /**
     * Evaluate heuristic function
     * @param state
     * @return result
     */
    public int evaluate(Node node);
}
