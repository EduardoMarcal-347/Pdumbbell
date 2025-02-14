package com.marcal.pdumbbell.dto.rest.shared;

import java.time.Instant;

public record LoginResponseDTO(
        int statusCode,
        String message,
        String token,
        Instant timestamp,
        Instant expiresAt
) implements BaseResponse{ }
