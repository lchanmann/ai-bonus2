package ai.util;

import java.util.Random;

import ai.core.Puzzle;

public class PuzzleFactory {
    
    public Puzzle create() {
        return create(true);
    }
    
    public Puzzle create(boolean randomized) {
        char[] layout = { '1', '2', '3', '4', '5', '6', '7', '8', '*'};
        
        if (randomized)
            randomize(layout);
        return new Puzzle(layout);
    }
    
    private char[] randomize(char[] layout) {
        int suffle = 50;
        Random rand = new Random();
        
        for (; suffle > 0; suffle--) {
            int position1 = rand.nextInt(layout.length);
            int position2 = rand.nextInt(layout.length);
            
            if (position1 != position2) {
                char temp = layout[position1];
                layout[position1] = layout[position2];
                layout[position2] = temp;
            }
        }
        return layout;
    }
}
