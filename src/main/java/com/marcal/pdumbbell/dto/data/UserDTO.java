package com.marcal.pdumbbell.dto.data;


import com.marcal.pdumbbell.entities.domain.FileMetadata;
import com.marcal.pdumbbell.entities.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String username;

    private String fullname;

    private String email;

    private String phoneNumber;

    private String passwordHash;

    private Boolean isEmailVerified;

    private Instant lastLogin;

    private List<Role> roles;

    private int failedLoginAttempts;

    private Boolean accountLocked;

    private String preferredLanguage;

    private Boolean isActive;

    private Instant deletedAt;

    private FileMetadata profilePicture;

    public UserDTO( String username, String fullname, String email, String phoneNumber, String passwordHash, Boolean isEmailVerified, Instant lastLogin, List<Role> roles, int failedLoginAttempts, Boolean accountLocked,
                    String preferredLanguage, Boolean isActive, Instant deletedAt, FileMetadata profilePicture ) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.isEmailVerified = isEmailVerified;
        this.lastLogin = lastLogin;
        this.roles = roles;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountLocked = accountLocked;
        this.preferredLanguage = preferredLanguage;
        this.isActive = isActive;
        this.deletedAt = deletedAt;
        this.profilePicture = profilePicture;
    }

    public UserDTO( ) {
    }
}
