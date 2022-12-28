package com.arunava.service;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> register(User user);

    ResponseEntity<?> login(LoginDto loginDto, HttpSession request) throws Exception;

	ResponseEntity<?> addManyUser(List<User> user) throws Exception;
}
