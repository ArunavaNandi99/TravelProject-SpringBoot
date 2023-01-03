package com.arunava.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @Email(message = "enter valid email")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password should not be empty")
    private String password;
}
