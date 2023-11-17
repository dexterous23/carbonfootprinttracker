package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.dto.CarbonFootprintInputDto;
import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.CarbonFootprintRecordRepository;
import com.assignment.carbonfootprinttracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarbonCalculatorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarbonFootprintRecordRepository recordRepository;

    public double getLatestFootprintForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Optional<CarbonFootprintRecord> latestRecord = recordRepository.findLatestByUserId(user.getId());
        return latestRecord.map(CarbonFootprintRecord::getCarbonFootprint).orElse(0.0);
    }

    public double calculateCarbonFootprint(CarbonFootprintInputDto inputDto) {
        double footprint = 0;
        footprint += inputDto.getTransportationData().getCarMiles() * 0.4;
        footprint += inputDto.getEnergyData().getElectricityUsage() * 0.7;
        return footprint;
    }
}
