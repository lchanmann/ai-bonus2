package ai.core;

import java.util.ArrayList;
import java.util.List;


public class Puzzle {

    /**
     * Goal state
     */
    public static final char[] GOAL_STATE = { '1', '2', '3', '4', '5', '6', '7', '8', '*' };

    /**
     * Blank character
     */
    public static final char BLANK = '*';

    /**
     * Initial state of the puzzle
     */
    private char[] layout;

    public Puzzle(char[] layout) {
        this.layout = layout;
    }

    public char[] getLayout() {
        return this.layout;
    }

    /**
     * Return possible actions for a given state
     * @param state
     */
    public static Action[] getActions(char[] state) {
        List<Action> actions = new ArrayList<Action>(Action.ALL);
        int boardSize = (int) Math.sqrt(state.length);

        for (int i=0; i<state.length; i++) {
            if (state[i] == BLANK) {
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
    public static char[] getResult(char[] state, Action action) {
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
        for (int i=0; i<GOAL_STATE.length; i++) {
            if (GOAL_STATE[i] != state[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ")
              .append(layout[0]).append("  ")
              .append(layout[1]).append("  ")
              .append(layout[2]).append(" |").append("\n")
          .append("| ")
              .append(layout[3]).append("  ")
              .append(layout[4]).append("  ")
              .append(layout[5]).append(" |").append("\n")
          .append("| ")
              .append(layout[6]).append("  ")
              .append(layout[7]).append("  ")
              .append(layout[8]).append(" |").append("\n");

        return sb.toString();
    }
}