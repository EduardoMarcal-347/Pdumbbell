package com.marcal.pdumbbell.entities.domain;

import com.marcal.pdumbbell.entities.base.BaseEntityUUID;
import com.marcal.pdumbbell.entities.enums.AccessRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@DynamicInsert
@Table( name = "user_info" )
public class User extends BaseEntityUUID {

    @Column( name = "username" )
    private String username;

    @Column( name = "full_name" )
    private String fullname;

    @Column( name = "email", unique = true )
    private String email;

    @Column( name = "phone_number", unique = true )
    private String phoneNumber;

    @Column( name = "password_hash" )
    private String passwordHash;

    @Column( name = "is_email_verified" )
    private Boolean isEmailVerified;

    @Column( name = "last_login" )
    private Instant lastLogin;


    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable( name = "users_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" ) )
    private List<Role> roles;

    @Column( name = "failed_login_attempts" )
    private int failedLoginAttempts;

    @Column( name = "account_locked" )
    private Boolean accountLocked;

    @Column( name = "preferred_language" )
    private String preferredLanguage;

    @Column( name = "is_active" )
    private Boolean isActive;

    @Column( name = "deleted_at" )
    private Instant deletedAt;

    @OneToOne
    @JoinColumn( name = "profile_picture_id" )
    private FileMetadata profilePicture;

    public User( UUID id, String username, String fullname, String email, String phoneNumber, String passwordHash, Boolean isEmailVerified, Instant lastLogin, int failedLoginAttempts, List<Role> roles, boolean accountLocked, String preferredLanguage,
                 Boolean isActive, Instant deletedAt, FileMetadata profilePicture ) {
        super( id );
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

    public User( ) {
    }
}
