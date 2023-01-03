package com.arunava.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Vacation {

    @jakarta.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "please enter hotel name")
    private String hotelName;

    @NotBlank(message = "please enter description")
    @Size(min = 10 ,max = 50, message ="Description  should be atLeast 10 characters max 50" )
    private String description;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "please set valid type 'resort','cruise','hotel'")
    private Type type;

    @NotBlank(message = "please set city")
    private String city;

    @NotBlank(message = "please set price")
    private Number price;

    @NotBlank(message = "select valid date")
    private Date validTill;

    private boolean soldOut;

    private String image;

}

