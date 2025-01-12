package com.marcal.pdumbbell.controllers;


import com.marcal.pdumbbell.common.annotation.AuthenticatedUser;
import com.marcal.pdumbbell.dto.data.UserDTO;
import com.marcal.pdumbbell.dto.shared.BaseResponse;
import com.marcal.pdumbbell.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping( "/pdumbbell/api/user" )
public class UserController {

    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping( "/me" )
    public ResponseEntity<BaseResponse> getUserSession( @AuthenticatedUser UserDTO user ) {
        return userService.getUserSession( user );
    }

}