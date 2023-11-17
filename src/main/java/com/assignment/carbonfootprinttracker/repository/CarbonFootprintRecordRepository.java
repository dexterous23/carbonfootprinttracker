package com.assignment.carbonfootprinttracker.repository;

import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarbonFootprintRecordRepository extends JpaRepository<CarbonFootprintRecord, Long> {

    @Query("SELECT r FROM CarbonFootprintRecord r WHERE r.user.id = :userId ORDER BY r.recordDate DESC")
    Optional<CarbonFootprintRecord> findLatestByUserId(Long userId);
}
