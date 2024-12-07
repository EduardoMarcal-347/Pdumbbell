package com.marcal.pdumbbell.dto.shared;

import java.time.Instant;

public record SuccessResponseDTO<T>(
        int statusCode,
        String message,
        Instant timestamp,
        T data
) implements BaseResponse { }
