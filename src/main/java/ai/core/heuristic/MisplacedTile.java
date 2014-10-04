package ai.core.heuristic;

import ai.core.Puzzle;

public class MisplacedTile implements Heuristic {

    private char[] goalState;

    public MisplacedTile(char[] goalState) {
        this.goalState = goalState;
    }

    public int evaluate(char[] state) {
        int result = 0;

        for (int i=0; i<state.length; i++) {
            if (state[i] != Puzzle.BLANK
                    && state[i] != goalState[i]) {
                result++;
            }
        }
        return result;
    }

}
