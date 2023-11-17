package com.assignment.carbonfootprinttracker.service;

import com.assignment.carbonfootprinttracker.dto.UserLoginDto;
import com.assignment.carbonfootprinttracker.dto.UserProfileDto;
import com.assignment.carbonfootprinttracker.dto.UserRegistrationDto;
import com.assignment.carbonfootprinttracker.model.User;
import com.assignment.carbonfootprinttracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUserAccount(UserRegistrationDto registrationDto) {
        if (userRepository.findByUsername(registrationDto.getUsername()) != null) {
            throw new RuntimeException("There is an account with that email address: " + registrationDto.getUsername());
        }
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public UserDetails login(UserLoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

    public void createOrUpdateUserProfile(String username, UserProfileDto profileDto) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        user.setLocation(profileDto.getLocation());
        user.setHouseholdSize(profileDto.getHouseholdSize());
        user.setSustainabilityGoals(profileDto.getSustainabilityGoals());
        userRepository.save(user);
    }

    public UserProfileDto getUserProfile(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        UserProfileDto profileDto = new UserProfileDto();
        profileDto.setLocation(user.getLocation());
        profileDto.setHouseholdSize(user.getHouseholdSize());
        profileDto.setSustainabilityGoals(user.getSustainabilityGoals());
        return profileDto;
    }
}

