package com.marcal.pdumbbell.utils;

import com.marcal.pdumbbell.dto.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.dto.shared.SuccessResponseDTO;

import java.time.Instant;
import java.util.Optional;

public class ResponseUtil {

    public static SuccessResponseDTO<?> successResponse( Object data ) {
        return new SuccessResponseDTO<>(
                200,
                "The request was successfully completed!",
                Instant.now( ),
                data
        );
    }

    public static SuccessResponseDTO<?> successResponse( Object data, String message ) {
        return new SuccessResponseDTO<>(
                200,
                Optional.of( message ).orElse( "The request was successfully completed!" ),
                Instant.now( ),
                data
        );
    }

    public static SuccessResponseDTO<?> createSuccessResponse( Object data, String schema ) {
        return successResponse( data, schema + " was successfully created!" );
    }

    public static ErrorResponseDTO errorResponse( int statusCode, String message ) {
        return new ErrorResponseDTO(
                statusCode,
                message,
                Instant.now( )
        );
    }

    public static ErrorResponseDTO conflictErrorResponse( String field, String schema ) {
        return errorResponse(
                33,
                "This " + field + " is already registered by another " + schema + "!"
        );
    }


}
