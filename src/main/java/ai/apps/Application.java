package ai.apps;

import java.util.Arrays;

import ai.core.Action;
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
    private Puzzle[] puzzles = new Puzzle[totalPuzzles];
    
    private int[] aStarSolutionCosts = new int[totalPuzzles];
    
    public void start() {
        createPuzzles();
        performAStarSearch();
        System.out.println(aStarSolutionCosts[0]);
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
        for (int i=0; i<puzzles.length; i++) {
            aStarSolutionCosts[i] = search.solve(puzzles[i]);
        }
    }

    private void createPuzzles() {
        PuzzleFactory factory = new PuzzleFactory();
        
        for (int i=0; i<totalPuzzles; i++) {
            puzzles[i] = factory.create();
        }
    }
}
