package ai.core.heuristic;

public abstract class Heuristic {

    protected char[] goalState;

    public Heuristic(char[] goalState) {
        this.goalState = goalState;
    }

    public char[] getGoalState() {
        return goalState;
    }

    /**
     * Evaluate heuristic function
     * @param state
     * @return result
     */
    public abstract int evaluate(char[] state);
}
