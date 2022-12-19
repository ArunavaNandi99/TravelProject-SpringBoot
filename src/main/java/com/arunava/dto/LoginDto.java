package com.arunava.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @Email(message = "enter valid email")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password should not be empty")
    private String password;
}
