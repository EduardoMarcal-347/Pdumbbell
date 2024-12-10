package com.marcal.pdumbbell.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserResponseDTO {

    private String username;

    private String fullname;

    private String email;

    private String phoneNumber;

    private String preferredLanguage;

    private Boolean isEmailVerified;

    private Instant lastLogin;

    private int failedLoginAttempts;

    private Boolean accountLocked;

    private Boolean isActive;

    private Instant deletedAt;

    public UserResponseDTO( String username, String fullname, String email, String phoneNumber, String preferredLanguage, Boolean isEmailVerified, Instant lastLogin, int failedLoginAttempts, Boolean accountLocked, Boolean isActive, Instant deletedAt ) {
        this.username = username;
        this.fullname = fullname;
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
}
