package ai.core.heuristic;

import ai.core.Puzzle;

public class MisplacedTile extends Heuristic {

    public MisplacedTile(char[] goalState) {
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
