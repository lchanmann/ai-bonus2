package ai.core.search;

import java.util.AbstractMap.SimpleEntry;

import ai.core.Node;
import ai.core.Puzzle;

public interface SearchAlgorithm {

    public SimpleEntry<Node, Integer> solve(Puzzle puzzle);
}
