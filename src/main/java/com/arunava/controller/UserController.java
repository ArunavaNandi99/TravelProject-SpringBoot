package com.arunava.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;
import com.arunava.service.UserService;

@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        return userService.register(user);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto, HttpSession request) throws Exception {
        return userService.login(loginDto,request);
    }
    
    @PostMapping("/addmany")
    public ResponseEntity<?> addManyUser(@RequestBody List<User> user) throws Exception{
		return userService.addManyUser(user);
    	
    }
} 