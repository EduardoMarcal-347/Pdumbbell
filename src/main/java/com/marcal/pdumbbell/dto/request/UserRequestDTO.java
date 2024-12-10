package com.marcal.pdumbbell.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

    @NotBlank(message = "Username must not be null")
    String username,

    @NotBlank(message = "Full name must not be null")
    String fullname,

    @NotBlank(message = "Email must not be null")
    @Email(message = "Invalid email address")
    String email,

    @NotBlank(message = "Phone number must not be null")
    String phoneNumber,

    @NotBlank(message = "Password must not be null")
    String password,

    @NotBlank(message = "Preferred language must not be null")
    String preferredLanguage

) { }
