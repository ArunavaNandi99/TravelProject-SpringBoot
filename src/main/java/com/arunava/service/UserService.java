package com.arunava.service;

import com.arunava.dto.LoginDto;
import com.arunava.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> register(User user);

    ResponseEntity<?> login(LoginDto loginDto) throws Exception;
}
