package ai.util;

import java.util.Random;

import ai.core.Action;
import ai.core.Puzzle;

public class PuzzleFactory {
    
    private static final PuzzleHelper puzzleHelper = PuzzleHelper.getInstance();

    public Puzzle create(int difficulty) {
        char[] layout = { '1', '2', '3', '4', '5', '6', '7', '8', '*'};
        
        return new Puzzle(randomize(layout, difficulty));
    }
    
    private char[] randomize(char[] layout, int difficulty) {
        Action[] actions;
        Random rand = new Random(System.nanoTime());
        int suffle  = difficulty + 30;

        for (; suffle > 0; suffle--) {
            actions = puzzleHelper.getActions(layout);
            int index = rand.nextInt(actions.length);
            layout = puzzleHelper.getResult(layout, actions[index]);
        }
        return layout;
    }
}
