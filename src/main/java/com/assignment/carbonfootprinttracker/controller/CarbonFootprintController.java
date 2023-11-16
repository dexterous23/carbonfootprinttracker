package com.assignment.carbonfootprinttracker.controller;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.service.CarbonCalculatorService;
import com.assignment.carbonfootprinttracker.service.CarbonFootprintService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> saveFootprint(@RequestBody CarbonFootprintInputDto inputDto, @AuthenticationPrincipal User user) {
        double footprint = carbonCalculatorService.calculateCarbonFootprint(inputDto);
        footprintService.saveCarbonFootprintRecord(user, footprint);
        return ResponseEntity.ok("Footprint saved successfully");
    }

    @GetMapping("/{userId}/history")
    public ResponseEntity<Object> getUserFootprintHistory(@PathVariable Long userId) {
        List<CarbonFootprintRecord> history = footprintService.getUserFootprintHistory(userId);
        return ResponseEntity.ok(history);
    }
}
