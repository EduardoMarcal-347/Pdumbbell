package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntityUUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user_info")
public class User extends BaseEntityUUID {

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "is_emai_verified")
    private String isEmailVerified;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "preferred_language")
    private String preferredLanguage;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToOne
    @JoinColumn( name = "profile_picture_id" )
    private FileMetadata profilePicture;

    public User( UUID id, String username, String fullName, String email, String phoneNumber, String passwordHash, String isEmailVerified, Instant lastLogin, int failedLoginAttempts, boolean accountLocked, String preferredLanguage, Boolean isActive, Instant deletedAt, FileMetadata profilePicture ) {
        super( id );
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.isEmailVerified = isEmailVerified;
        this.lastLogin = lastLogin;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountLocked = accountLocked;
        this.preferredLanguage = preferredLanguage;
        this.isActive = isActive;
        this.deletedAt = deletedAt;
        this.profilePicture = profilePicture;
    }

    public User( ) {
    }
}
