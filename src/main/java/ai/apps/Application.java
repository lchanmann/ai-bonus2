package ai.apps;

import ai.core.Puzzle;
import ai.core.heuristic.CombinedHeuristic;
import ai.core.heuristic.Heuristic;
import ai.core.heuristic.ManhattanDistance;
import ai.core.heuristic.EuclideanDistance;
import ai.core.search.AStarSearch;
import ai.core.search.HillClimbingSearch;
import ai.core.search.SimulatedAnnealingSearch;
import ai.core.search.SearchAlgorithm;
import ai.core.search.SearchResult;
import ai.util.PuzzleFactory;

public class Application {

    /**
     * The total number of puzzles
     */
    private static final int totalPuzzles = 50;

    /**
//     * The puzzle list
     */
    private Puzzle[] puzzles = new Puzzle[totalPuzzles];
//    private Puzzle puzzle = new Puzzle(new char[] {'7','*','8','5','4','1','6','3','2'});
    
    private SearchResult[] aStarResults = new SearchResult[totalPuzzles];
    private SearchResult[] hillClimbingResults = new SearchResult[totalPuzzles];
    private SearchResult[] simulatedAnnealingResults = new SearchResult[totalPuzzles];

    private Heuristic manhattan;
    private Heuristic euclidean;
    private Heuristic combined;

    public Application() {
        manhattan = new ManhattanDistance(Puzzle.GOAL_STATE);
        euclidean = new EuclideanDistance(Puzzle.GOAL_STATE);
        combined = new CombinedHeuristic(Puzzle.GOAL_STATE);
    }

    public void start() {
        createPuzzles();
        performAStarSearch();
        performHillClimbingSearch();
        performSimulatedAnnealingSearch();
    }

    public static void main(String[] args) {
        new Application().start();
    }

    /**
     * A* search
     *     - h(n) - Manhattan distance
     */
    private void performAStarSearch() {
        SearchAlgorithm search = new AStarSearch(manhattan);

        for (int i=0; i<puzzles.length; i++) {
            aStarResults[i] = search.solve(puzzles[i]);
            System.out.println("A* (Manhattan) = " + aStarResults[i] + "\n");
        }
    }

    /**
     * Hill-climbing search
     */
    private void performHillClimbingSearch() {
        SearchAlgorithm search = new HillClimbingSearch(manhattan);

        for (int i=0; i<puzzles.length; i++) {
            hillClimbingResults[i] = search.solve(puzzles[i]);
            System.out.println("Hill-climbing = " + hillClimbingResults[i] + "\n");
        }
    }
    
    private void performSimulatedAnnealingSearch() {
    	SearchAlgorithm search = new SimulatedAnnealingSearch(manhattan);
    	
    	for (int i=0; i<puzzles.length; i++) {
    		simulatedAnnealingResults[i] = search.solve(puzzles[i]);
    		System.out.println("Simulated Annealing = " + simulatedAnnealingResults[i] + "\n");
    	}
    }

    private void createPuzzles() {
        PuzzleFactory factory = new PuzzleFactory();
        
        for (int i=0; i<totalPuzzles; i++) {
            puzzles[i] = factory.create(i);
        }
    }
}
