package ai.core.search;

import ai.core.Node;
import ai.core.Puzzle;
import ai.core.heuristic.Heuristic;

public class HillClimbingSearch {

    private Heuristic heuristic;

    public HillClimbingSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
    }
    
    /**
     * Solve a given puzzle using hill-climbing algorithm
     * @param puzzle
     * @return Solution cost for the puzzle
     */
    public SearchResult solve(Puzzle puzzle) {
        Node currentNode = new Node(puzzle.getLayout());
        return null;
    }
}
