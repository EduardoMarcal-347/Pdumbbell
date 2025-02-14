package com.marcal.pdumbbell.dto.rest.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "Username/Email must not be null")
        String identifier,

        @NotBlank(message = "Password must not be null")
        String password
) { }
