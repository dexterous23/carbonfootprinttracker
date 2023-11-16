package com.assignment.carbonfootprinttracker.repository;

import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarbonFootprintRecordRepository extends JpaRepository<CarbonFootprintRecord, Long> {
    List<CarbonFootprintRecord> findByUserId(Long userId);
}
