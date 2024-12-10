package com.marcal.pdumbbell.controllers;

import com.marcal.pdumbbell.dto.request.LoginRequestDTO;
import com.marcal.pdumbbell.dto.request.UserRequestDTO;
import com.marcal.pdumbbell.dto.shared.BaseResponse;
import com.marcal.pdumbbell.services.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping( "auth" )
public class AuthController {

    private final AuthService authService;

    public AuthController( AuthService authService ) { this.authService = authService; }

    @PostMapping( "/signup" )
    public ResponseEntity<BaseResponse> create( @Valid @RequestBody UserRequestDTO dto ) {
        return authService.sign( dto );
    }

    @PostMapping( "/login" )
    public ResponseEntity<BaseResponse> login( @Valid @RequestBody LoginRequestDTO dto ) {
        return null;
    }
}
