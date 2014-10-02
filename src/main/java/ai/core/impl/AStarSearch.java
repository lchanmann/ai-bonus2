package ai.core.impl;

import ai.core.Heuristic;
import ai.core.Puzzle;

public class AStarSearch {

    private Heuristic heuristic;

    public AStarSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    public void solve(Puzzle puzzle) {
        StringBuilder sb = new StringBuilder();

        sb.append(puzzle.toString())
          .append("h = ")
          .append(heuristic.evaluate(puzzle.getLayout()))
          .append("\n\n");
        System.out.print(sb.toString());
    }
}
