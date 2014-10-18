package ai.util;

import java.util.ArrayList;
import java.util.List;

import ai.core.Action;
import ai.core.Puzzle;

public class PuzzleHelper {

    private static PuzzleHelper instance = null;
    
    public static PuzzleHelper getInstance() {
        if (instance == null) {
            instance = new PuzzleHelper();
        }
        return instance;
    }
    
    /**
     * Return possible actions for a given state
     * @param state
     */
    public Action[] getActions(char[] state) {
        List<Action> actions = new ArrayList<Action>(Action.ALL);
        int boardSize = (int) Math.sqrt(state.length);

        for (int i=0; i<state.length; i++) {
            if (state[i] == Puzzle.BLANK) {
                int row = i / boardSize + 1;
                int column = i % boardSize + 1;

                if (row == 1) actions.remove(Action.Down);
                if (row == boardSize) actions.remove(Action.Up);
                if (column == 1) actions.remove(Action.Right);
                if (column == boardSize) actions.remove(Action.Left);
                break;
            }
        }
        return actions.toArray(new Action[0]);
    }

    /**
     * Transition model - Result(s, a) -> s'
     * @param state
     * @param action
     * @retun New state as a result of the action
     */
    public char[] getResult(char[] state, Action action) {
        for (int i=0; i<state.length; i++) {
            if (state[i] == Puzzle.BLANK) {
                char[] result = new char[state.length];
                int boardSize = (int) Math.sqrt(state.length);
                int iNew = i;

                if (action == Action.Left) iNew += 1;
                else if (action == Action.Right) iNew -= 1;
                else if (action == Action.Up) iNew += boardSize;
                else if (action == Action.Down) iNew -= boardSize;
                for (int j=0; j<state.length; j++) {
                    if (j == i) result[j] = state[iNew];
                    else if (j == iNew) result[j] = state[i];
                    else result[j] = state[j];
                }
                return result;
            }
        }
        return state;
    }

    /**
     * Goal test - check if the given state is a goal
     * @param state
     * @return True or False
     */
    public boolean goalTest(char[] state) {
        for (int i=0; i<Puzzle.GOAL_STATE.length; i++) {
            if (Puzzle.GOAL_STATE[i] != state[i]) {
                return false;
            }
        }
        return true;
    }
}
