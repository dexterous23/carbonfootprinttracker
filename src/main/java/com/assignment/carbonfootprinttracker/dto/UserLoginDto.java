package com.assignment.carbonfootprinttracker.dto;

public class UserLoginDto {
    private String username;
    private String password;

    // Constructor
    public UserLoginDto() {
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
