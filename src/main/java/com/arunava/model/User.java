package com.arunava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "please enter valid firstName")
    private String fname;
    @NotBlank(message = "please enter valid lastName")
    private String lname;
    @NotBlank(message = "please enter email")
    @Email(message = "please enter valid email example:'demo.example.com'")
    private String email;
    @Size(min = 5 , message = "password should not be 7 character")
    @NotBlank(message = "please enter password")
    private String password;
}
