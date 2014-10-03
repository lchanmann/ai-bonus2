package ai.core.impl;

import java.util.ArrayList;
import java.util.List;

import ai.core.Action;
import ai.core.Heuristic;
import ai.core.Node;
import ai.core.Puzzle;

public class AStarSearch {

    private Heuristic heuristic;

    public AStarSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * Solve a given puzzle
     * @param puzzle
     * @return Solution cost for the puzzle
     */
    public int solve(Puzzle puzzle) {
        Node node = new Node(puzzle.getLayout());
        // TODO: set a reasonable capacity
        List<Node> frontier = new ArrayList<Node>();
        List<Node> explored = new ArrayList<Node>();

        frontier.add(node);
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            if (frontier.isEmpty()) return -1; // Failure
            if (puzzle.goalTest(node.getState())) return i; // Found solution
            for (Action action : puzzle.getActions(node.getState())) {
                Node childNode = createNode(puzzle, node, action);
                boolean isInFrontier = frontier.indexOf(childNode) != -1;
                boolean isInExplored = explored.indexOf(childNode) != -1;

                if (!isInFrontier && !isInExplored) {
                    frontier.add(childNode);
                }
            }
        }

//        StringBuilder sb = new StringBuilder();
//
//        sb.append(puzzle.toString())
//          .append("h = ")
//          .append(heuristic.evaluate(puzzle.getLayout()))
//          .append("\n\n");
//        System.out.print(sb.toString());

        return Integer.MAX_VALUE;
    }

    private Node createNode(Puzzle puzzle, Node node, Action action) {
        char[] state = puzzle.getResult(node.getState(), action);
        return new Node(state, node);
    }
}
