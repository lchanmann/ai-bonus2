package ai.core;

import java.util.*;

public class Simulator{

	public static void main(String[] args){
		//This comparator function allows us to use Collections.BinarySort to sort the Puzzle objects by their final path cost
		Comparator<Puzzle> solutionCost = new Comparator<Puzzle>() {
			public int compare(Puzzle p1, Puzzle p2) {
				return p1.getSolutionCost().compareTo(p2.getSolutionCost());
			}
		};
		int i;
		ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();
		//for loop to generate puzzles
		for(i = 0; i < 50; i++){
			//Creates a new puzzle object - still needs parameters
			Puzzle p = new Puzzle(/*whatever parameter goes here*/);
			puzzles.add(p);
		}
		
		//for loop to run A* search, hill-climbing, simulated-annealing algorithms
		for(i = 0; i < p.size(); i++){
			Puzzle temp = p.get(i);
			//run search algorithms on temp
		}
		
		//Sort the arraylist by solution cost
		Collections.sort(p, solutionCost);
		
	}
}