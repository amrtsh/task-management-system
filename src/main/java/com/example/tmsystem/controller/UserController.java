package com.example.tmsystem.controller;

import com.example.tmsystem.dto.UserDto;
import com.example.tmsystem.model.User;
import com.example.tmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @PostMapping
//
//
//    @PutMapping
//
//    @DeleteMapping(path = "/id")
}
