package com.assignment.carbonfootprinttracker.dto;

import com.assignment.carbonfootprinttracker.model.ConsumptionData;
import com.assignment.carbonfootprinttracker.model.DietData;
import com.assignment.carbonfootprinttracker.model.EnergyData;
import com.assignment.carbonfootprinttracker.model.TransportationData;

public class CarbonFootprintInputDto {
    private TransportationData transportationData;
    private EnergyData energyData;
    private DietData dietData;

    public CarbonFootprintInputDto(TransportationData transportationData, EnergyData energyData, DietData dietData, ConsumptionData consumptionData) {
        this.transportationData = transportationData;
        this.energyData = energyData;
        this.dietData = dietData;
        this.consumptionData = consumptionData;
    }

    public TransportationData getTransportationData() {
        return transportationData;
    }

    public void setTransportationData(TransportationData transportationData) {
        this.transportationData = transportationData;
    }

    public EnergyData getEnergyData() {
        return energyData;
    }

    public void setEnergyData(EnergyData energyData) {
        this.energyData = energyData;
    }

    public DietData getDietData() {
        return dietData;
    }

    public void setDietData(DietData dietData) {
        this.dietData = dietData;
    }

    public ConsumptionData getConsumptionData() {
        return consumptionData;
    }

    public void setConsumptionData(ConsumptionData consumptionData) {
        this.consumptionData = consumptionData;
    }

    private ConsumptionData consumptionData;
    // ... constructors, getters, setters
}