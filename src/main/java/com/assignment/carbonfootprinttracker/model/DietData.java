package com.assignment.carbonfootprinttracker.model;

public class DietData {
    private double meatConsumption;
    private double dairyConsumption;

    public double getMeatConsumption() {
        return meatConsumption;
    }

    public void setMeatConsumption(double meatConsumption) {
        this.meatConsumption = meatConsumption;
    }

    public double getDairyConsumption() {
        return dairyConsumption;
    }

    public void setDairyConsumption(double dairyConsumption) {
        this.dairyConsumption = dairyConsumption;
    }

    public DietData(double meatConsumption, double dairyConsumption) {
        this.meatConsumption = meatConsumption;
        this.dairyConsumption = dairyConsumption;
    }
}
