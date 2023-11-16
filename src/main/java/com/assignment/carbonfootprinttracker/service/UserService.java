package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.dto.UserProfileDto;
import com.assignment.carbonfootprinttracker.dto.UserRegistrationDto;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUserAccount(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        return userRepository.save(user);
    }

    public void updateUserProfile(Long userId, UserProfileDto profileDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setLocation(profileDto.getLocation());
        user.setHouseholdSize(profileDto.getHouseholdSize());
        user.setSustainabilityGoals(profileDto.getSustainabilityGoals());
        userRepository.save(user);
    }

    public UserProfileDto getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfileDto profileDto = new UserProfileDto();
        profileDto.setLocation(user.getLocation());
        profileDto.setHouseholdSize(user.getHouseholdSize());
        profileDto.setSustainabilityGoals(user.getSustainabilityGoals());
        return profileDto;
    }
}
