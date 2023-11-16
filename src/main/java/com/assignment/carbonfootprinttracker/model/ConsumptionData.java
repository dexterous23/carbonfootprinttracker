package com.assignment.carbonfootprinttracker.model;

public class ConsumptionData {
    private double goodsPurchased;
    private double servicesPurchased;

    public ConsumptionData(double goodsPurchased, double servicesPurchased) {
        this.goodsPurchased = goodsPurchased;
        this.servicesPurchased = servicesPurchased;
    }

    public double getGoodsPurchased() {
        return goodsPurchased;
    }

    public void setGoodsPurchased(double goodsPurchased) {
        this.goodsPurchased = goodsPurchased;
    }

    public double getServicesPurchased() {
        return servicesPurchased;
    }

    public void setServicesPurchased(double servicesPurchased) {
        this.servicesPurchased = servicesPurchased;
    }
}
