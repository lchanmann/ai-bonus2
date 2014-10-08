package ai.core;

public class ResultData {
	private int AStarCost;
	private double AStarExecTime;
	private int AStarExpanded;
	private int HillClimbCost;
	private double HillClimbExecTime;
	private int HillClimbExpanded;
	private int SimulatedAnnealingCost;
	private double SimulatedAnnealingExecTime;
	private int SimulatedAnnealingExpanded;
	
	public ResultData(){
		
	}
	
	public int getAStarCost() {
		return AStarCost;
	}
	public void setAStarCost(int aStarCost) {
		AStarCost = aStarCost;
	}
	public double getAStarExecTime() {
		return AStarExecTime;
	}
	public void setAStarExecTime(double aStarExecTime) {
		AStarExecTime = aStarExecTime;
	}
	public int getAStarExpanded() {
		return AStarExpanded;
	}
	public void setAStarExpanded(int aStarExpanded) {
		AStarExpanded = aStarExpanded;
	}
	public int getHillClimbCost() {
		return HillClimbCost;
	}
	public void setHillClimbCost(int hillClimbCost) {
		HillClimbCost = hillClimbCost;
	}
	public double getHillClimbExecTime() {
		return HillClimbExecTime;
	}
	public void setHillClimbExecTime(double hillClimbExecTime) {
		HillClimbExecTime = hillClimbExecTime;
	}
	public int getHillClimbExpanded() {
		return HillClimbExpanded;
	}
	public void setHillClimbExpanded(int hillClimbExpanded) {
		HillClimbExpanded = hillClimbExpanded;
	}
	public int getSimulatedAnnealingCost() {
		return SimulatedAnnealingCost;
	}
	public void setSimulatedAnnealingCost(int simulatedAnnealingCost) {
		SimulatedAnnealingCost = simulatedAnnealingCost;
	}
	public double getSimulatedAnnealingExecTime() {
		return SimulatedAnnealingExecTime;
	}
	public void setSimulatedAnnealingExecTime(double simulatedAnnealingExecTime) {
		SimulatedAnnealingExecTime = simulatedAnnealingExecTime;
	}
	public int getSimulatedAnnealingExpanded() {
		return SimulatedAnnealingExpanded;
	}
	public void setSimulatedAnnealingExpanded(int simulatedAnnealingExpanded) {
		SimulatedAnnealingExpanded = simulatedAnnealingExpanded;
	}
}
