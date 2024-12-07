package com.marcal.pdumbbell.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserResponseDTO {

    private String username;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String preferredLanguage;

    private String isEmailVerified;

    private Instant lastLogin;

    private int failedLoginAttempts;

    private boolean accountLocked;

    private Boolean isActive;

    private Instant deletedAt;

    public UserResponseDTO( String username, String fullName, String email, String phoneNumber, String preferredLanguage, String isEmailVerified, Instant lastLogin, int failedLoginAttempts, boolean accountLocked, Boolean isActive, Instant deletedAt ) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preferredLanguage = preferredLanguage;
        this.isEmailVerified = isEmailVerified;
        this.lastLogin = lastLogin;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountLocked = accountLocked;
        this.isActive = isActive;
        this.deletedAt = deletedAt;
    }

    public UserResponseDTO( ) {
    }
}
