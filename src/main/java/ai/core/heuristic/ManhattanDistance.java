package ai.core.heuristic;

import ai.core.Node;
import ai.core.Puzzle;

public class ManhattanDistance implements Heuristic {

    private char[] goalState;

    public ManhattanDistance(char[] goalState) {
        this.goalState = goalState;
    }

    public int evaluate(Node node) {
        int totalDistance = 0;
        int boardSize = (int) Math.sqrt(goalState.length);
        char[] state = node.getState();

        for (int i=0; i<state.length; i++) {
            if (state[i] != Puzzle.BLANK) {
                for (int j=0; j<goalState.length; j++) {
                    if (state[i] == goalState[j]) {
                        int horizontalDistance = Math.abs(i % boardSize - j % boardSize);
                        int verticalDistance = Math.abs(i / boardSize - j / boardSize);

                        totalDistance += horizontalDistance + verticalDistance;
                    }
                }
            }
        }
        return totalDistance;
    }
}
