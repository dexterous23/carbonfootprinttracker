package com.assignment.carbonfootprinttracker.controller;

import com.assignment.carbonfootprinttracker.dto.UserProfileDto;
import com.assignment.carbonfootprinttracker.dto.UserRegistrationDto;
import com.assignment.carbonfootprinttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        userService.registerNewUserAccount(registrationDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRegistrationDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("User logged in successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid login credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok("User logged out successfully");
    }


    @PostMapping("/profile")
    public ResponseEntity<?> createOrUpdateUserProfile(@RequestBody UserProfileDto profileDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        userService.createOrUpdateUserProfile(currentUserName, profileDto);
        return ResponseEntity.ok("User profile updated successfully");
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        UserProfileDto profileDto = userService.getUserProfile(currentUserName);
        return ResponseEntity.ok(profileDto);
    }
}
