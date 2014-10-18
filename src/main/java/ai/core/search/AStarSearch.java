package ai.core.search;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import ai.core.Action;
import ai.core.Node;
import ai.core.Puzzle;
import ai.core.heuristic.Heuristic;

public class AStarSearch implements SearchAlgorithm {

    private Heuristic heuristic;

    public AStarSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    /**
     * Solve a given puzzle using A* algorithm
     * @param puzzle
     * @return Solution cost for the puzzle
     */
    public SimpleEntry<Node, Integer> solve(Puzzle puzzle) {
        Node currentNode = new Node(puzzle.getLayout());
        List<Node> frontier = new ArrayList<Node>();
        List<Node> explored = new ArrayList<Node>();

        solving(puzzle);
        frontier.add(currentNode);
        for (int i=0; i<Short.MAX_VALUE; i++) {
            if (frontier.isEmpty()) return new SimpleEntry<>(currentNode, explored.size());
            if (puzzle.goalTest(currentNode.getState()))
                return new SimpleEntry<>(currentNode, explored.size());

            currentNode = getBestNode(frontier);
            for (Action action : puzzle.getActions(currentNode.getState())) {
                Node childNode = createNode(puzzle, currentNode, action);
                boolean isInFrontier = frontier.indexOf(childNode) != -1;
                boolean isInExplored = explored.indexOf(childNode) != -1;

                if (!isInFrontier && !isInExplored) {
                    frontier.add(childNode);
                }
            }
            explored.add(frontier.remove(frontier.indexOf(currentNode)));
        }
        return new SimpleEntry<>(currentNode, explored.size());
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

    private Node getBestNode(List<Node> frontier) {
        Node bestNode = null;

        for (Node node : frontier) {
            if (bestNode == null) bestNode = node;
            else if (getCost(node) < getCost(bestNode)) {
                bestNode = node;
            }
        }
        return bestNode;
    }

    /**
     * Total estimated cost -> f = g + h
     * @param node
     * @return
     */
    private int getCost(Node node) {
        return node.getPathCost() + heuristic.evaluate(node);
    }

    private Node createNode(Puzzle puzzle, Node parent, Action action) {
        char[] state = puzzle.getResult(parent.getState(), action);
        return new Node(state, parent, action);
    }
}
