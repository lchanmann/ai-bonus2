package ai.core;

import ai.util.PuzzleHelper;

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

    /**
     * helper
     */
    private static final PuzzleHelper helper = PuzzleHelper.getInstance();;

    public Puzzle(char[] layout) {
        this.layout = layout;
    }

    public char[] getLayout() {
        return this.layout;
    }

    public Action[] getActions(char[] state) {
        return helper.getActions(state);
    }

    public char[] getResult(char[] state, Action action) {
        return helper.getResult(state, action);
    }

    public boolean goalTest(char[] state) {
        return helper.goalTest(state);
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