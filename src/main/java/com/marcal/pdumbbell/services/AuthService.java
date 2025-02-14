package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.mappers.impl.data.UserMapper;
import com.marcal.pdumbbell.dto.mappers.impl.rest.UserRestMapper;
import com.marcal.pdumbbell.dto.rest.request.LoginRequestDTO;
import com.marcal.pdumbbell.dto.rest.request.UserRequestDTO;
import com.marcal.pdumbbell.dto.rest.response.UserResponseDTO;
import com.marcal.pdumbbell.dto.rest.shared.BaseResponse;
import com.marcal.pdumbbell.dto.rest.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.security.auth.UserDetailsImpl;
import com.marcal.pdumbbell.security.service.JWTokenService;
import com.marcal.pdumbbell.security.service.PasswordService;
import com.marcal.pdumbbell.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<BaseResponse> signup( UserRequestDTO request ) {
        ErrorResponseDTO conflictFieldMessage = checkUniqueFieldsValues( request );
        if ( conflictFieldMessage != null ) {
            return ResponseEntity
                    .status( HttpStatus.CONFLICT )
                    .body( conflictFieldMessage );
        }
        User user = UserRestMapper.INSTANCE.toEntity( request );
        user.setPasswordHash( passwordService.encodePassword( request.password( ) ) );
        UserResponseDTO responseDTO = UserRestMapper.INSTANCE.toDto( userRepository.save( user ) );
        return ResponseEntity.ok( ResponseUtil.createSuccessResponse( responseDTO, "User" ) );
    }

    public ResponseEntity<BaseResponse> login( LoginRequestDTO request ) {
        User requestUser = loadByIdentifier( request.identifier() ).filter( User::getIsActive ).orElse( null );
        if ( requestUser == null ) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST )
                    .body( ResponseUtil.unexistentLoginIdentifierError( ));
        }
        if ( requestUser.getAccountLocked( ) ) {
            return ResponseEntity.status( HttpStatus.LOCKED )
                    .body( ResponseUtil.lockedAccountError( ) );
        }
        if ( !passwordService.matches( request.password( ), requestUser.getPasswordHash( ) ) ) {
            handleFailedLoginAttempt( requestUser );
            return ResponseEntity.status( HttpStatus.UNAUTHORIZED )
                    .body( ResponseUtil.badPasswordError( ) );
        }
        updateSuccessfulLogin( requestUser );
        UserDetailsImpl userDetails = new UserDetailsImpl( requestUser );
        return ResponseEntity.ok( ResponseUtil.loginSuccessResponse( jwtTokenService.generateToken( userDetails ) ) );
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

    public Optional<User> loadByIdentifier( String identifier ) {
        if ( identifier.contains( "@" ) ) {
            return userRepository.findByEmail( identifier );
        }
        return userRepository.findByUsername( identifier );
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

}
