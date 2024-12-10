package com.marcal.pdumbbell.services.auth;

import com.marcal.pdumbbell.dto.mappers.request.UserRequestMapper;
import com.marcal.pdumbbell.dto.mappers.response.UserResponseMapper;
import com.marcal.pdumbbell.dto.request.LoginRequestDTO;
import com.marcal.pdumbbell.dto.request.UserRequestDTO;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.dto.shared.BaseResponse;
import com.marcal.pdumbbell.dto.shared.ErrorResponseDTO;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordService passwordService;

    public AuthService( UserRepository userRepository, PasswordService passwordService ) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public ResponseEntity<BaseResponse> sign( UserRequestDTO dto ) {
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

    public ResponseEntity<BaseResponse> login( LoginRequestDTO dto ) {
        User user = findUserByIdentifier( dto );
        if ( user == null ) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST )
                    .body( ResponseUtil.unexistentLoginIdentifierError( ) );
        }
        return null;
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

    private User findUserByIdentifier( LoginRequestDTO dto ) {
        if ( dto.identifier( ).contains( "@" ) ) {
            return userRepository.findByEmail( dto.identifier( ) );
        }
        return userRepository.findByUsername( dto.identifier( ) );
    }
}
