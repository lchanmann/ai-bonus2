package ai.core.heuristic;

import ai.core.Puzzle;

public class MisplacedTilts extends Heuristic {

    public MisplacedTilts(char[] goalState) {
        super(goalState);
    }

    @Override
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
