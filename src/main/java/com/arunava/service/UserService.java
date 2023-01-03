package com.arunava.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;

public interface UserService {
    ResponseEntity<?> register(User user);

    ResponseEntity<?> login(LoginDto loginDto, HttpSession request) throws Exception;

	ResponseEntity<?> addManyUser(List<User> user) throws Exception;
}
