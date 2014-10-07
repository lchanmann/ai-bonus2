package ai.core.heuristic;

import ai.core.Node;

public class CombinedHeuristic implements Heuristic {

    private char[] goalState;

    public CombinedHeuristic(char[] goalState) {
        this.goalState = goalState;
    }

    @Override
    public int evaluate(Node node) {
        int manhantten = new ManhattanDistance(goalState).evaluate(node);
        int euclidean = new EuclideanDistance(goalState).evaluate(node);

        return Math.max(manhantten, euclidean);
    }

}
