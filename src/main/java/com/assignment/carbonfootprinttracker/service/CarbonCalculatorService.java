package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import org.springframework.stereotype.Service;

@Service
public class CarbonCalculatorService {

    public double calculateCarbonFootprint(CarbonFootprintInputDto inputDto) {
        double footprint = 0;
        footprint += inputDto.getTransportationData().getCarMiles() * 0.4;
        footprint += inputDto.getEnergyData().getElectricityUsage() * 0.7;
        return footprint;
    }
}
