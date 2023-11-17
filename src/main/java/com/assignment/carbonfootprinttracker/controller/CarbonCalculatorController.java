package com.assignment.carbonfootprinttracker.controller;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import com.assignment.carbonfootprinttracker.service.CarbonCalculatorService;
import com.assignment.carbonfootprinttracker.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carboncalculator")
public class CarbonCalculatorController {

    @Autowired
    private CarbonCalculatorService carbonCalculatorService;

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateFootprint() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        double footprint = carbonCalculatorService.getLatestFootprintForUser(currentUserName);
        List<String> recommendations = recommendationService.generateRecommendationsForUser(currentUserName);
        return ResponseEntity.ok(new CalculationResultDto(footprint, recommendations));
    }

    private static class CalculationResultDto {
        private final double footprint;
        private final List<String> recommendations;

        public CalculationResultDto(double footprint, List<String> recommendations) {
            this.footprint = footprint;
            this.recommendations = recommendations;
        }

        public double getFootprint() {
            return footprint;
        }

        public List<String> getRecommendations() {
            return recommendations;
        }
    }
}
