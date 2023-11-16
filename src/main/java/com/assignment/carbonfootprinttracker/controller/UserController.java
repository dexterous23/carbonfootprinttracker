package com.assignment.carbonfootprinttracker.controller;

import com.assignment.carbonfootprinttracker.dto.UserProfileDto;
import com.assignment.carbonfootprinttracker.dto.UserRegistrationDto;
import com.assignment.carbonfootprinttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        try {
            userService.registerNewUserAccount(registrationDto);
            return ResponseEntity.ok("User successfully registered");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration error: " + e.getMessage());
        }
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileDto profileDto) {
        try {
            userService.updateUserProfile(userId, profileDto);
            return ResponseEntity.ok("Profile updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating profile: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable Long userId) {
        try {
            UserProfileDto profileDto = userService.getUserProfile(userId);
            return ResponseEntity.ok(profileDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
