package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.mappers.impl.data.UserMapper;
import com.marcal.pdumbbell.dto.mappers.impl.rest.UserRestMapper;

import com.marcal.pdumbbell.dto.rest.response.UserResponseDTO;
import com.marcal.pdumbbell.dto.rest.shared.BaseResponse;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<BaseResponse> getUserSession( UserDTO user ) {
        if ( user == null ) {
            return ResponseEntity.status( HttpStatus.UNAUTHORIZED )
                    .body( ResponseUtil.invalidTokenError( ) );
        }
        User entity = UserMapper.INSTANCE.toEntity( user );
        UserResponseDTO response = UserRestMapper.INSTANCE.toDto( entity );
        return ResponseEntity.ok( ResponseUtil.successResponse( response, null ) );
    }


}
