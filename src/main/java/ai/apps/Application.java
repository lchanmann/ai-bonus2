package ai.apps;

import java.util.ArrayList;
import java.util.List;

import ai.core.Puzzle;
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
    }

    public static void main(String[] args) {
        new Application().start();
        System.out.println("Done!");
    }
    
    private void createPuzzles() {
        puzzles = new ArrayList<Puzzle>(totalPuzzles);
        PuzzleFactory factory = new PuzzleFactory();
        
        for (int i=0; i<totalPuzzles; i++) {
            puzzles.add(factory.create());
        }
    }
}
