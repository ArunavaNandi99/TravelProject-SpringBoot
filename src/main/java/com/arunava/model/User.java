package com.arunava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(max = 7 , message = "password should not be 7 character")
    @NotBlank(message = "please enter password")
    private String password;
}
