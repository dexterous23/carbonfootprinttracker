package com.assignment.carbonfootprinttracker.model;


import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String location;
    private int householdSize;
    private String sustainabilityGoals;

    // Constructors
    public User() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

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
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
