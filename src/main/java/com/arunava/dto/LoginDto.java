package com.arunava.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDto {
    @Email(message = "enter valid email")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password should not be empty")
    private String password;
}
