package com.assignment.carbonfootprinttracker.repository;

import com.assignment.carbonfootprinttracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}