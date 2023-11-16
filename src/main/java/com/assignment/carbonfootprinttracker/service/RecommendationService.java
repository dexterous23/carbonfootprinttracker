package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    public List<String> generateRecommendations(CarbonFootprintInputDto inputDto) {
        List<String> recommendations = new ArrayList<>();

        // Example: Provide recommendations based on transportation data
        if (inputDto.getTransportationData().getCarMiles() > 50) {
            recommendations.add("Consider using public transport or carpooling to reduce car mileage.");
        }

        // Example: Provide recommendations based on energy usage
        if (inputDto.getEnergyData().getElectricityUsage() > 500) {
            recommendations.add("Consider switching to energy-efficient appliances.");
        }

        // Add more personalized recommendations based on diet, energy, and consumption data

        return recommendations;
    }
}

