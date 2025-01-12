package com.marcal.pdumbbell.repositories;

import com.marcal.pdumbbell.entities.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String identifier);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<User> findByUsername( String username);
    Optional<User> findByEmail(String email);
}
