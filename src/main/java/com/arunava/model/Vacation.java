package com.arunava.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Vacation {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String hotelName;

    private String description;

    @Enumerated(EnumType.STRING)

    private Type type;

    private String city;

    private Number numberOfDays;

    private Double price;

    private Date validTill;

    private boolean soldOut;

    private String image;

}

