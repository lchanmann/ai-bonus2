package ai.core.impl;

import java.util.ArrayList;
import java.util.List;

import ai.core.Action;
import ai.core.Node;
import ai.core.Puzzle;
import ai.core.SearchResult;
import ai.core.heuristic.Heuristic;

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
    public SearchResult solve(Puzzle puzzle) {
        Node node = new Node(puzzle.getLayout());
        // TODO: set a reasonable capacity
        List<Node> frontier = new ArrayList<Node>();
        List<Node> explored = new ArrayList<Node>();
        Long startTime = System.nanoTime();

        solving(puzzle);
        frontier.add(node);
        for (int i=0; i<Short.MAX_VALUE; i++) {
            if (frontier.isEmpty()) return new Failure("No solution found");
            if (puzzle.goalTest(node.getState()))
                return new Solution(node.getPathCost(), explored.size(), System.nanoTime() - startTime);

            node = getBestNode(frontier);
            for (Action action : puzzle.getActions(node.getState())) {
                Node childNode = createNode(puzzle, node, action);
                boolean isInFrontier = frontier.indexOf(childNode) != -1;
                boolean isInExplored = explored.indexOf(childNode) != -1;

                if (!isInFrontier && !isInExplored) {
                    frontier.add(childNode);
                }
            }
            explored.add(frontier.remove(frontier.indexOf(node)));
        }
        return new Failure("Too many state spaces");
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

    private Node getBestNode(List<Node> frontier) {
        int bestIndex = 0;
        int bestCost = Integer.MAX_VALUE;

        for (int i=0; i<frontier.size(); i++) {
            Node node = frontier.get(i);
            int costEstimate = node.getPathCost() + heuristic.evaluate(node.getState());

            if (bestCost > costEstimate) {
                bestIndex = i;
                bestCost = costEstimate;
            }
        }
        return frontier.get(bestIndex);
    }

    private Node createNode(Puzzle puzzle, Node node, Action action) {
        char[] state = puzzle.getResult(node.getState(), action);
        return new Node(state, node);
    }
}
