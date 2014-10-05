package ai.core.heuristic;

import ai.core.Puzzle;

public class EuclideanDistance implements Heuristic {

    private char[] goalState;

    public EuclideanDistance(char[] goalState) {
        this.goalState = goalState;
    }

    @Override
    public int evaluate(char[] state) {
        int result = 0;
        int boardSize = (int) Math.sqrt(goalState.length);

        for (int i=0; i<state.length; i++) {
            if (state[i] != Puzzle.BLANK) {
                for (int j=0; j<goalState.length; j++) {
                    if (state[i] == goalState[j]) {
                        int horizontalDistance = Math.abs(i % boardSize - j % boardSize);
                        int verticalDistance = Math.abs(i / boardSize - j / boardSize);

                        result += (int) Math.sqrt(horizontalDistance*horizontalDistance + verticalDistance*verticalDistance);
                    }
                }
            }
        }
        return result;
    }
}
