package ai.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

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
import ai.core.ResultData;

public class Application {
	/* Comparator sorts by AStarCost in descending order*/
	public static final Comparator<ResultData> solutionCost = new Comparator<ResultData>() {
		public int compare(ResultData rd1, ResultData rd2) {
			return rd1.getAStarCost() - rd2.getAStarCost();
		}
	};
	
    /**
     * The total number of puzzles
     */
    private static final int totalPuzzles = 50;

    /**
//     * The puzzle list
     */
    private Puzzle[] puzzles = new Puzzle[totalPuzzles];
//    private Puzzle puzzle = new Puzzle(new char[] {'1','2','3','4','5','6','8','7','*'});
    
    private SearchResult[] aStarResults = new SearchResult[totalPuzzles];
    private SearchResult[] hillClimbingResults = new SearchResult[totalPuzzles];
    private SearchResult[] simulatedAnnealingResults = new SearchResult[totalPuzzles];
    private ArrayList<ResultData> resultData = new ArrayList<ResultData>();

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
        for(int i = 0; i < aStarResults.length; i++){
        	ResultData result = new ResultData();
        	result.setAStarCost(aStarResults[i].getCost());
        	result.setAStarExecTime(aStarResults[i].getExecutionTimeInSecond());
        	result.setAStarExpanded(aStarResults[i].getExpanded());
        	result.setHillClimbCost(hillClimbingResults[i].getCost());
        	result.setHillClimbExecTime(hillClimbingResults[i].getExecutionTimeInSecond());
        	result.setHillClimbExpanded(hillClimbingResults[i].getExpanded());
        	result.setSimulatedAnnealingCost(simulatedAnnealingResults[i].getCost());
        	result.setSimulatedAnnealingExecTime(simulatedAnnealingResults[i].getExecutionTimeInSecond());
        	result.setSimulatedAnnealingExpanded(simulatedAnnealingResults[i].getExpanded());
        	resultData.add(result);
        }
        Collections.sort(resultData, solutionCost);
        
        try{
        	BufferedWriter bw1 = new BufferedWriter(new FileWriter("results.txt"));
        	bw1.write("Instance - AStarCost - AStarExecTime - AStarNodesExpanded - HillClimbCost - HillClimbExecTime - HillClimbNodesExpanded - SimAnnealingCost - SimAnnealingExecTime - SimAnnealingNodesExpanded");
        	bw1.newLine();
        	for(int i = 0; i < resultData.size(); i++){
        		ResultData temp = resultData.get(i);
        		bw1.write((i+1) + " - " + temp.getAStarCost() + " - " + temp.getAStarExecTime() + " - " + temp.getAStarExpanded() + " - " + temp.getHillClimbCost() + " - " + temp.getHillClimbExecTime() + " - " + temp.getHillClimbExpanded() + " - " + temp.getSimulatedAnnealingCost() + " - " + temp.getSimulatedAnnealingExecTime() + " - " + temp.getSimulatedAnnealingExpanded());
        		bw1.newLine();
        	}
        	bw1.close();
        } catch (Exception e){
        	System.err.println(e);
        } 
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
