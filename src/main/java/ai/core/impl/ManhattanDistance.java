package ai.core.impl;

import ai.core.Heuristic;

public class ManhattanDistance implements Heuristic {

    private char[] goalState;
    private static final char BLANK = '*';

    public ManhattanDistance(char[] goalState) {
        this.goalState = goalState;
    }

    public int evaluate(char[] state) {
        int totalDistance = 0;
        int stateSize = (int) Math.sqrt(goalState.length);

        for (int i=0; i<state.length; i++) {
            if (state[i] != BLANK) {
                for (int j=0; j<goalState.length; j++) {
                    if (state[i] == goalState[j]) {
                        int horizontalDistance = Math.abs(i % stateSize - j % stateSize);
                        int verticalDistance = Math.abs(i / stateSize - j / stateSize);

                        totalDistance += horizontalDistance + verticalDistance;
                    }
                }
            }
        }
        return totalDistance;
    }
}
