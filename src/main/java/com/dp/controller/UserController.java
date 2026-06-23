package com.dp.controller;


import com.dp.entity.UserEntity;
import com.dp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity userEntity = userService.save(user);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }


    @GetMapping("get-user/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
        UserEntity userEntity = userService.findById(userId);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
