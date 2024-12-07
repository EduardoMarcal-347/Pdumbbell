package com.marcal.pdumbbell.dto.shared;

import java.time.Instant;

public record ErrorResponseDTO(
        int statusCode,
        String message,
        Instant timestamp
) implements BaseResponse { }
