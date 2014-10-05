package ai.core.search;

import java.util.ArrayList;
import java.util.List;

import ai.core.Action;
import ai.core.Node;
import ai.core.Puzzle;
import ai.core.heuristic.Heuristic;

public class HillClimbingSearch implements SearchAlgorithm {

    private Heuristic heuristic;

    public HillClimbingSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
    }
    
    /**
     * Solve a given puzzle using hill-climbing algorithm
     * @param puzzle
     * @return Solution cost for the puzzle
     */
    public SearchResult solve(Puzzle puzzle) {
        Node current = new Node(puzzle.getLayout());
        Node neighbor = null;
        int expanded = 0;
        Long startTime = System.nanoTime();

        solving(puzzle);
        while (true) {
            if (puzzle.goalTest(current.getState()))
                return new Solution(current.getPathCost(), expanded, System.nanoTime() - startTime);

            List<Node> children = expandNode(current, puzzle);
            expanded++;
            neighbor = getBestNode(children);
            if (getValue(neighbor) <= getValue(current))
                return new LocalMaximum(current, expanded, System.nanoTime() - startTime);
            current = neighbor;
        }
    }

    private void solving(Puzzle puzzle) {
        StringBuilder sb = new StringBuilder();

        sb.append("Start solving: ")
          .append("\n")
          .append(puzzle.toString())
          .append("h = ")
          .append(heuristic.evaluate(puzzle.getLayout()));
        System.out.println(sb.toString());
    }

    private Node getBestNode(List<Node> nodes) {
        Node bestNode = null;

        for (Node node : nodes) {
            if (bestNode == null) bestNode = node;
            else if (getValue(bestNode) <= getValue(node)) {
                bestNode = node;
            }
        }
        return bestNode;
    }

    private int getValue(Node node) {
        int estimate = heuristic.evaluate(node.getState());

        // The bigger the estimate to goal the smaller the value should be given
        // The goal node has the highest value = 0
        return -1 * estimate;
    }

    private List<Node> expandNode(Node node, Puzzle puzzle) {
        List<Node> nodes = new ArrayList<Node>();
        char[] state = node.getState();

        for (Action action : puzzle.getActions(state)) {
            char[] newState = puzzle.getResult(state, action);

            nodes.add(new Node(newState, node));
        }
        return nodes;
    }
}
