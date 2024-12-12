package com.marcal.pdumbbell.exceptions.handler;

import com.marcal.pdumbbell.dto.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.utils.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Log4j2
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions( MethodArgumentNotValidException ex ) {
        return ResponseEntity
                .status( HttpStatus.BAD_REQUEST )
                .body( ResponseUtil.errorResponse( 400,
                        ex.getBindingResult( ).getFieldErrors( ).stream( )
                                .findFirst( )
                                .map( DefaultMessageSourceResolvable::getDefaultMessage )
                                .orElse( null )
                ) );
    }

    @ExceptionHandler( AuthenticationServiceException.class )
    public ResponseEntity<ErrorResponseDTO> handleUnauthorizedError( AuthenticationServiceException ex ) {
        return ResponseEntity
                .status( HttpStatus.UNAUTHORIZED )
                .body( ResponseUtil.unauthorizedError( null ) );
    }

    @ExceptionHandler( AccessDeniedException.class )
    public ResponseEntity<ErrorResponseDTO> handleForbiddenError( AccessDeniedException ex ) {
        return ResponseEntity
                .status( HttpStatus.FORBIDDEN )
                .body( ResponseUtil.forbiddenError( ) );
    }

    @ExceptionHandler( Exception.class )
    public ResponseEntity<ErrorResponseDTO> handleGlobalExceptions( Exception e ) {
        log.error( "Error during API request: ", e );
        return ResponseEntity
                .status( HttpStatus.INTERNAL_SERVER_ERROR )
                .body( ResponseUtil.internalServerError( ) );
    }

}