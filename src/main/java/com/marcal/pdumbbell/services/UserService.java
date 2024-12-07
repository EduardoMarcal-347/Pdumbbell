package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.mappers.request.UserRequestMapper;
import com.marcal.pdumbbell.dto.mappers.response.UserResponseMapper;
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
public class UserService {

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<BaseResponse> create( UserRequestDTO dto ) {
        ErrorResponseDTO conflictFieldMessage = checkUniqueFieldsValues( dto );
        if ( conflictFieldMessage != null ) {
            return ResponseEntity
                    .status( HttpStatus.CONFLICT )
                    .body( conflictFieldMessage );
        }
        User user = UserRequestMapper.INSTANCE.toEntity( dto );
        UserResponseDTO responseDTO = UserResponseMapper.INSTANCE.toDto( userRepository.save( user ) );
        return ResponseEntity.ok( ResponseUtil.createSuccessResponse( responseDTO, "User" ) );
    }

    private ErrorResponseDTO checkUniqueFieldsValues( UserRequestDTO dto ) {
        Map<String, Boolean> uniquenessChecks = new HashMap<>( );
        uniquenessChecks.put( "identifier", userRepository.existsByUsername( dto.username( ) ) );
        uniquenessChecks.put( "email", userRepository.existsByEmail( dto.email( ) ) );
        uniquenessChecks.put( "phone_number", userRepository.existsByPhoneNumber( dto.phoneNumber( ) ) );

        return uniquenessChecks.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .map(entry -> ResponseUtil.conflictErrorResponse(entry.getKey(), "User"))
                .orElse(null);
    }

}
