package flixbus.assignment.model;

public class Information {
    private Integer numLines;
    private double totalBusCost;
    private double totalDriverCost;
    private double totalCost;

    public Information(Integer numLines, double totalBusCost, double totalDriverCost, double totalCost) {
        this.numLines = numLines;
        this.totalBusCost = totalBusCost;
        this.totalDriverCost = totalDriverCost;
        this.totalCost = totalCost;
    }

    public Integer getNumLines() {
        return numLines;
    }

    public void setNumLines(Integer numLines) {
        this.numLines = numLines;
    }

    public double getTotalBusCost() {
        return totalBusCost;
    }

    public void setTotalBusCost(double totalBusCost) {
        this.totalBusCost = totalBusCost;
    }

    public double getTotalDriverCost() {
        return totalDriverCost;
    }

    public void setTotalDriverCost(double totalDriverCost) {
        this.totalDriverCost = totalDriverCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
