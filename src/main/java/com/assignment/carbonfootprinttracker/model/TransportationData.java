package com.assignment.carbonfootprinttracker.model;

public class TransportationData {
    private double carMiles;
    private double publicTransportMiles;

    public TransportationData(double carMiles, double publicTransportMiles) {
        this.carMiles = carMiles;
        this.publicTransportMiles = publicTransportMiles;
    }

    public double getCarMiles() {
        return carMiles;
    }

    public void setCarMiles(double carMiles) {
        this.carMiles = carMiles;
    }

    public double getPublicTransportMiles() {
        return publicTransportMiles;
    }

    public void setPublicTransportMiles(double publicTransportMiles) {
        this.publicTransportMiles = publicTransportMiles;
    }



}
