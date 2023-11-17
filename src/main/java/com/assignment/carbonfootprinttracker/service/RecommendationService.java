package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.model.CarbonFootprintRecord;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.CarbonFootprintRecordRepository;
import com.assignment.carbonfootprinttracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    @Autowired
    private CarbonFootprintRecordRepository recordRepository;

    @Autowired
    private UserRepository userRepository;

    public List<String> generateRecommendationsForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Optional<CarbonFootprintRecord> latestRecordOpt = recordRepository.findLatestByUserId(user.getId());
        if (latestRecordOpt.isEmpty()) {
            throw new IllegalStateException("No carbon footprint record found for user");
        }

        CarbonFootprintRecord latestRecord = latestRecordOpt.get();
        return generateRecommendationsBasedOnRecord(latestRecord);
    }

    private List<String> generateRecommendationsBasedOnRecord(CarbonFootprintRecord record) {
        List<String> recommendations = new ArrayList<>();

        if (record.getCarbonFootprint() > 300) {
            recommendations.add("Consider reducing your energy usage to lower your carbon footprint.");
        }
        return recommendations;
    }
}
