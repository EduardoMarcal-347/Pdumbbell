package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.dto.mappers.response.UserResponseMapper;
import com.marcal.pdumbbell.dto.response.UserResponseDTO;
import com.marcal.pdumbbell.dto.shared.BaseResponse;
import com.marcal.pdumbbell.entities.domain.User;
import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AuthService authService;

    private final UserRepository userRepository;

    public UserService( AuthService authService, UserRepository userRepository ) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    public ResponseEntity<BaseResponse> findUserByToken( String token ) {
        User user = authService.loadUserByToken( token ).orElse( null );
        if ( user == null ) {
            return ResponseEntity.status( HttpStatus.UNAUTHORIZED )
                    .body( ResponseUtil.invalidTokenError( ) );
        }
        UserResponseDTO responseDTO = UserResponseMapper.INSTANCE.toDto( userRepository.save( user ) );
        return ResponseEntity.ok( ResponseUtil.successResponse( responseDTO, null ) );
    }


}
