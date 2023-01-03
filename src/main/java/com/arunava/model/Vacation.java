package com.arunava.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Vacation {

    @jakarta.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "please enter hotel name")
    private String hotelName;

    @NotNull(message = "please enter description")
    @Size(min = 10 ,max = 50, message ="Description  should be atLeast 10 characters max 50" )
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "please set valid type 'resort','cruise','hotel'")
    private Type type;

    @NotNull(message = "please set city")
    private String city;

    @NotNull(message = "please set price")
    private Number price;

    @NotNull(message = "select valid date")
    private Date validTill;

    private boolean soldOut;

    private String image;



}

