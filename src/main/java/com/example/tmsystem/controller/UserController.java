package com.example.tmsystem.controller;

import com.example.tmsystem.dto.UserAuthDto;
import com.example.tmsystem.dto.UserDto;
import com.example.tmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserAuthDto userAuthDto) {
        UserDto createdUser = userService.createUser(userAuthDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}
