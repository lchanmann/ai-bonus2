package ai.core;

public class Puzzle {
    
    private char[] layout;
    private int heuristic;
    private int solutionCost;
    private int expandedNode;
    private int executionTime;
    
    public Puzzle(char[] layout) {
        this.layout = layout;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ")
              .append(layout[0]).append("  ")
              .append(layout[1]).append("  ")
              .append(layout[2]).append(" |").append("\n")
          .append("| ")
              .append(layout[3]).append("  ")
              .append(layout[4]).append("  ")
              .append(layout[5]).append(" |").append("\n")
          .append("| ")
              .append(layout[6]).append("  ")
              .append(layout[7]).append("  ")
              .append(layout[8]).append(" |").append("\n");

        return sb.toString();
    }
}