package com.assignment.carbonfootprinttracker.model;

public class EnergyData {
    private double electricityUsage;
    private double gasUsage;

    public double getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(double electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    public double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(double gasUsage) {
        this.gasUsage = gasUsage;
    }

    public EnergyData(double electricityUsage, double gasUsage) {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
    }
}
