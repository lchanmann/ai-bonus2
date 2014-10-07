package ai.core.heuristic;

import ai.core.Node;
import ai.core.Puzzle;

public class MisplacedTile implements Heuristic {

    private char[] goalState;

    public MisplacedTile(char[] goalState) {
        this.goalState = goalState;
    }

    public int evaluate(Node node) {
        int result = 0;
        char[] state = node.getState();

        for (int i=0; i<state.length; i++) {
            if (state[i] != Puzzle.BLANK
                    && state[i] != goalState[i]) {
                result++;
            }
        }
        return result;
    }

}
