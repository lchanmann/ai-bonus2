package ai.core.heuristic;

public class CombinedHeuristic implements Heuristic {

    private char[] goalState;

    public CombinedHeuristic(char[] goalState) {
        this.goalState = goalState;
    }

    @Override
    public int evaluate(char[] state) {
        int manhantten = new ManhattanDistance(goalState).evaluate(state);
        int euclidean = new EuclideanDistance(goalState).evaluate(state);

        return Math.max(manhantten, euclidean);
    }

}
