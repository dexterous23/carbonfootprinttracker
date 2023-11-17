package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.CarbonFootprintRecordRepository;
import com.assignment.carbonfootprinttracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarbonFootprintService {

    private final CarbonFootprintRecordRepository recordRepository;

    private final UserRepository userRepository;

    public CarbonFootprintService(CarbonFootprintRecordRepository recordRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
    }

    public void saveCarbonFootprintRecord(String username, double footprint) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        CarbonFootprintRecord record = new CarbonFootprintRecord();
        record.setUser(user);
        record.setCarbonFootprint(footprint);
        record.setRecordDate(LocalDate.now());
        recordRepository.save(record);
    }



    public Optional<CarbonFootprintRecord> getUserFootprintHistory(Long userId) {
        return recordRepository.findLatestByUserId(userId);
    }
}
