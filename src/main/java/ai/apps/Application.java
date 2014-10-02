package ai.apps;

import java.util.ArrayList;
import java.util.List;

import ai.core.Puzzle;
import ai.core.impl.AStarSearch;
import ai.core.impl.ManhattanDistance;
import ai.util.PuzzleFactory;

public class Application {
    
    /**
     * The total number of puzzles
     */
    private static final int totalPuzzles = 50;
    
    /**
     * The puzzle list
     */
    private List<Puzzle> puzzles;
    
    public void start() {
        createPuzzles();
        performAStarSearch();
    }

    public static void main(String[] args) {
        new Application().start();
    }

    /**
     * A* search
     *     - h(n) - Manhattan distance
     */
    private void performAStarSearch() {
        AStarSearch search = new AStarSearch(new ManhattanDistance(Puzzle.GOAL_STATE));
        for (Puzzle puzzle : puzzles) {
            search.solve(puzzle);
        }
    }

    private void createPuzzles() {
        puzzles = new ArrayList<Puzzle>(totalPuzzles);
        PuzzleFactory factory = new PuzzleFactory();
        
        for (int i=0; i<totalPuzzles; i++) {
            puzzles.add(factory.create());
        }
    }
}
