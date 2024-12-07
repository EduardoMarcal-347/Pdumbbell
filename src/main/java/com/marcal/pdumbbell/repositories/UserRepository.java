package com.marcal.pdumbbell.repositories;

import com.marcal.pdumbbell.entities.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String identifier);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
