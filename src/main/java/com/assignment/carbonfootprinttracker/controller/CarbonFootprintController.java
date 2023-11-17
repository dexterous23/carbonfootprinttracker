package com.assignment.carbonfootprinttracker.controller;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.service.CarbonCalculatorService;
import com.assignment.carbonfootprinttracker.service.CarbonFootprintService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carbonfootprint")
public class CarbonFootprintController {

    private final CarbonFootprintService footprintService;
    private final CarbonCalculatorService carbonCalculatorService;

    public CarbonFootprintController(CarbonFootprintService footprintService, CarbonCalculatorService carbonCalculatorService) {
        this.footprintService = footprintService;
        this.carbonCalculatorService = carbonCalculatorService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveFootprint(@RequestBody CarbonFootprintInputDto inputDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        double footprint = carbonCalculatorService.calculateCarbonFootprint(inputDto);
        footprintService.saveCarbonFootprintRecord(currentUserName, footprint);
        return ResponseEntity.ok("Footprint saved successfully");
    }


    @GetMapping("/{userId}/history")
    public ResponseEntity<Object> getUserFootprintHistory(@PathVariable Long userId) {
        Optional<CarbonFootprintRecord> history = footprintService.getUserFootprintHistory(userId);
        return ResponseEntity.ok(history);
    }
}
