package com.marcal.pdumbbell.controllers;


import com.marcal.pdumbbell.services.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/pdumbbell/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<?> getById(@PathVariable String id) {
//        return userService.getById(id);
//    }
//
//    @PutMapping("/id/{id}")
//    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody UserDto dto) {
//        return userService.update(id, dto);
//    }
//
//    @DeleteMapping("/id/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return userService.delete(id);
//    }
}