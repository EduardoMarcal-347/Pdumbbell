package com.marcal.pdumbbell.dto.rest.shared;

import java.time.Instant;
import java.util.List;

public record PaginatedResponseDTO<T>(
        int statusCode,
        String message,
        List<T> items,
        int totalItems,
        int totalPages,
        Instant timestamp
) implements BaseResponse { }
