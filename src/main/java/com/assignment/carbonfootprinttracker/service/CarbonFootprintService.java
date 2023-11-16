package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.CarbonFootprintRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarbonFootprintService {

    private final CarbonFootprintRecordRepository recordRepository;

    public CarbonFootprintService(CarbonFootprintRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void saveCarbonFootprintRecord(User user, double footprint) {
        CarbonFootprintRecord record = new CarbonFootprintRecord();
        record.setUser(user);
        record.setCarbonFootprint(footprint);
        record.setRecordDate(LocalDate.now());
        recordRepository.save(record);
    }

    public List<CarbonFootprintRecord> getUserFootprintHistory(Long userId) {
        return recordRepository.findByUserId(userId);
    }
}
