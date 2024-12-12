package com.marcal.pdumbbell.utils;

import com.marcal.pdumbbell.dto.shared.LoginResponseDTO;
import com.marcal.pdumbbell.dto.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.dto.shared.SuccessResponseDTO;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public class ResponseUtil {

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

    public static LoginResponseDTO loginSuccessResponse( String token ) {
        return new LoginResponseDTO(
                200,
                "Token was successfully generated!",
                token,
                ZonedDateTime.now( ZoneId.of( "America/SaoPaulo" ) ).toInstant( ),
                ZonedDateTime.now( ZoneId.of( "America/SaoPaulo" ) ).plusHours( 5 ).toInstant( )
        );
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

    public static ErrorResponseDTO internalServerError( ) {
        return errorResponse(
                500,
                "An unexpected error has occurred. Please try again later."
        );
    }

    public static ErrorResponseDTO unexistentLoginIdentifierError( ) {
        return errorResponse(
                400,
                "Unexistent user registered with this username/email"
        );
    }

    public static ErrorResponseDTO unauthorizedError( ) {
        return errorResponse(
                401,
                "Unauthorized: Authentication failed"
        );
    }

    public static ErrorResponseDTO badPasswordError( ) {
        return errorResponse(
                401,
                "Unauthorized: Authentication failed due to wrong password"
        );
    }

    public static ErrorResponseDTO forbiddenError( ) {
        return errorResponse(
                403,
                "Forbidden: Access is denied"
        );
    }

    public static ErrorResponseDTO lockedAccountError( ) {
        return errorResponse(
                423,
                "The account is locked due to too many failed attempts."
        );
    }

}
