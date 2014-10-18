package ai.core.search;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ai.core.Action;
import ai.core.Node;
import ai.core.Puzzle;
import ai.core.heuristic.Heuristic;

public class SimulatedAnnealingSearch implements SearchAlgorithm {
	 private Heuristic heuristic;

	    public SimulatedAnnealingSearch(Heuristic heuristic) {
	        this.heuristic = heuristic;
	    }
	    
	    /**
	     * Solve a given puzzle using Simulated Annealing
	     * @param puzzle
	     * @return Solution cost for the puzzle
	     */
	    public SimpleEntry<Node, Integer> solve(Puzzle puzzle) {
	        Node current = new Node(puzzle.getLayout());
	        Node neighbor = null;
	        int expanded = 0;
	        int deltaE;
	        double chance;
	        double temperature = 1000;

	        Random choice = new Random(System.nanoTime());
	        Random probability = new Random(System.nanoTime());
	        solving(puzzle);
	        while (temperature > 1) {
	            List<Node> children = expandNode(current, puzzle);
	            expanded++;
	            neighbor = children.get(choice.nextInt(children.size()));
	            if (getValue(neighbor) <= getValue(current)) {
	                deltaE = getValue(neighbor) - getValue(current);
	            	double prob = Math.pow(Math.E, (deltaE/temperature));
	            	chance = probability.nextDouble();
	            	if(chance < prob){
	            		current = neighbor;
	            	}
	            } else {
	            	current = neighbor;
	            }
	            temperature *= 0.9;
	        }
	        return new SimpleEntry<>(current, expanded);
	    }

	    private void solving(Puzzle puzzle) {
	        StringBuilder sb = new StringBuilder();

	        sb.append("Start solving: ")
	          .append("\n")
	          .append(puzzle.toString())
	          .append("h = ")
	          .append(heuristic.evaluate(new Node(puzzle.getLayout())));
	        System.out.println(sb.toString());
	    }


	    private int getValue(Node node) {
	        int estimate = heuristic.evaluate(node);

	        // The bigger the estimate to goal the smaller the value should be given
	        // The goal node has the highest value = 0
	        return -1 * estimate;
	    }

	    private List<Node> expandNode(Node node, Puzzle puzzle) {
	        List<Node> nodes = new ArrayList<Node>();
	        char[] state = node.getState();

	        for (Action action : puzzle.getActions(state)) {
	            char[] newState = puzzle.getResult(state, action);

	            nodes.add(new Node(newState, node, action));
	        }
	        return nodes;
	    }
}
