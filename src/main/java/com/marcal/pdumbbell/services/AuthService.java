package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.mappers.data.UserMapper;
import com.marcal.pdumbbell.dto.mappers.request.UserRequestMapper;
import com.marcal.pdumbbell.dto.mappers.response.UserResponseMapper;
import com.marcal.pdumbbell.dto.request.LoginRequestDTO;
import com.marcal.pdumbbell.dto.request.UserRequestDTO;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.dto.shared.BaseResponse;
import com.marcal.pdumbbell.dto.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.security.auth.UserDetailsImpl;
import com.marcal.pdumbbell.security.service.JWTokenService;
import com.marcal.pdumbbell.security.service.PasswordService;
import com.marcal.pdumbbell.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordService passwordService;

    private final JWTokenService jwtTokenService;

    public AuthService( UserRepository userRepository, PasswordService passwordService, JWTokenService jwtTokenService ) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.jwtTokenService = jwtTokenService;
    }

    public ResponseEntity<BaseResponse> signup( UserRequestDTO dto ) {
        ErrorResponseDTO conflictFieldMessage = checkUniqueFieldsValues( dto );
        if ( conflictFieldMessage != null ) {
            return ResponseEntity
                    .status( HttpStatus.CONFLICT )
                    .body( conflictFieldMessage );
        }
        User user = UserRequestMapper.INSTANCE.toEntity( dto );
        user.setPasswordHash( passwordService.encodePassword( dto.password( ) ) );
        UserResponseDTO responseDTO = UserResponseMapper.INSTANCE.toDto( userRepository.save( user ) );
        return ResponseEntity.ok( ResponseUtil.createSuccessResponse( responseDTO, "User" ) );
    }

    public ResponseEntity<BaseResponse> login( LoginRequestDTO request ) {
        Optional<User> requestUser = loadByIdentifier( request );

        return requestUser.map( user -> {
            if ( user.getAccountLocked( ) ) {
                return ResponseEntity.status( HttpStatus.LOCKED )
                        .body( ResponseUtil.lockedAccountError( ) );
            }
            if ( !passwordService.matches( request.password( ), user.getPasswordHash( ) ) ) {
                handleFailedLoginAttempt( user );
                return ResponseEntity.status( HttpStatus.UNAUTHORIZED )
                        .body( ResponseUtil.badPasswordError( ) );
            }
            
        } ).orElseGet( ( ) -> ResponseEntity.status( HttpStatus.BAD_REQUEST )
                .body( ResponseUtil.unexistentLoginIdentifierError( ) ) );
    }

    private ErrorResponseDTO checkUniqueFieldsValues( UserRequestDTO dto ) {
        Map<String, Boolean> uniquenessChecks = new HashMap<>( );
        uniquenessChecks.put( "username", userRepository.existsByUsername( dto.username( ) ) );
        uniquenessChecks.put( "email", userRepository.existsByEmail( dto.email( ) ) );
        uniquenessChecks.put( "phone_number", userRepository.existsByPhoneNumber( dto.phoneNumber( ) ) );

        return uniquenessChecks.entrySet( ).stream( )
                .filter( Map.Entry::getValue )
                .findFirst( )
                .map( entry -> ResponseUtil.conflictErrorResponse( entry.getKey( ), "User" ) )
                .orElse( null );
    }

    private Optional<User> loadByIdentifier( LoginRequestDTO dto ) {
        if ( dto.identifier( ).contains( "@" ) ) {
            return userRepository.findByEmail( dto.identifier( ) );
        }
        return userRepository.findByUsername( dto.identifier( ) );
    }

    private void handleFailedLoginAttempt( User user ) {
        UserDTO dto = UserMapper.INSTANCE.toDto( user );
        dto.setFailedLoginAttempts( user.getFailedLoginAttempts( ) + 1 );
        if ( dto.getFailedLoginAttempts( ) >= 5 ) {
            dto.setAccountLocked( true );
        }
        user = UserMapper.INSTANCE.updateEntity( user, dto );
        userRepository.save( user );
    }

    private void updateSuccessfulLogin( User user ) {
        UserDTO dto = UserMapper.INSTANCE.toDto( user );
        dto.setLastLogin( Instant.now( ) );
        dto.setFailedLoginAttempts( 0 );
        user = UserMapper.INSTANCE.updateEntity( user, dto );
        userRepository.save( user );
    }

    private UserDetailsImpl createUserDetails( User user ) {
        return new UserDetailsImpl( user );
    }
}
