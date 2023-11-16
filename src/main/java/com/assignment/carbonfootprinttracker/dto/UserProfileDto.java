package com.assignment.carbonfootprinttracker.dto;

public class UserProfileDto {
    private String location;
    private int householdSize;
    private String sustainabilityGoals;

    // Constructors
    public UserProfileDto() {
    }

    // Getters
    public String getLocation() {
        return location;
    }

    public int getHouseholdSize() {
        return householdSize;
    }

    public String getSustainabilityGoals() {
        return sustainabilityGoals;
    }

    // Setters
    public void setLocation(String location) {
        this.location = location;
    }

    public void setHouseholdSize(int householdSize) {
        this.householdSize = householdSize;
    }

    public void setSustainabilityGoals(String sustainabilityGoals) {
        this.sustainabilityGoals = sustainabilityGoals;
    }
}
