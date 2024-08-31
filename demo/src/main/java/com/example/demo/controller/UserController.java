package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(User user){
        User newuUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newuUser); 
    }

    public ResponseEntity<List<User>> getUser(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}