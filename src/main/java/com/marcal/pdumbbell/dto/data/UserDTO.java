package com.marcal.pdumbbell.dto.data;


import com.marcal.pdumbbell.entities.domain.FileMetadata;
import com.marcal.pdumbbell.entities.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID id;

    private String username;

    private String fullname;

    private String email;

    private String phoneNumber;

    private Boolean isEmailVerified;

    private Instant lastLogin;

    private List<Role> roles;

    private int failedLoginAttempts;

    private Boolean accountLocked;

    private String preferredLanguage;

    private Boolean isActive;

    private Instant deletedAt;

    private FileMetadata profilePicture;

    public UserDTO( UUID id, String username, String fullname, String email, String phoneNumber, Boolean isEmailVerified, Instant lastLogin, List<Role> roles, int failedLoginAttempts, Boolean accountLocked,
                    String preferredLanguage, Boolean isActive, Instant deletedAt, FileMetadata profilePicture ) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
