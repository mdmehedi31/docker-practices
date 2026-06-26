package com.dp.controller;


import com.dp.entity.UserEntity;
import com.dp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) throws IOException {
        String saveResponse = userService.addName(user.getName());
        return new ResponseEntity<>(saveResponse, HttpStatus.CREATED);
    }


    @GetMapping("get-user/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
        UserEntity userEntity = userService.findById(userId);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<String>> getNames() throws IOException {

        List<String> names = this.userService.getNames();
        return new ResponseEntity<>(names, HttpStatus.OK);

    }

}
