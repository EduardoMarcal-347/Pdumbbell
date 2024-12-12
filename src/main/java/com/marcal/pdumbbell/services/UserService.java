package com.marcal.pdumbbell.services;

import com.marcal.pdumbbell.repositories.UserRepository;
import com.marcal.pdumbbell.security.service.PasswordService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository, PasswordService passwordService ) {
        this.userRepository = userRepository;
    }


}
