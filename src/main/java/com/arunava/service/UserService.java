package com.arunava.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    ResponseEntity<?> register(User user);

    ResponseEntity<?> login(LoginDto loginDto, HttpSession request) throws Exception;

	ResponseEntity<?> addManyUser(List<User> user) throws Exception;
}
