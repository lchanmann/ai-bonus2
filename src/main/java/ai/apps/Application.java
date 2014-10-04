package ai.apps;

import ai.core.Puzzle;
import ai.core.heuristic.ManhattanDistance;
import ai.core.search.AStarSearch;
import ai.core.search.SearchResult;
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
    
    private SearchResult[] aStarSearchResults = new SearchResult[totalPuzzles];
    
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
        for (int i=0; i<puzzles.length; i++) {
            aStarSearchResults[i] = search.solve(puzzles[i]);
            System.out.println("A* (Manhattan) = " + aStarSearchResults[i] + "\n");
        }
    }

    private void createPuzzles() {
        PuzzleFactory factory = new PuzzleFactory();
        
        for (int i=0; i<totalPuzzles; i++) {
            puzzles[i] = factory.create();
        }
    }
}
