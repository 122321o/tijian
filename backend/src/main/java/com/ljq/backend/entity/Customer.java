package com.ljq.backend.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private int id;
    private String name;
    private String idCard;
    private boolean gender;
    private LocalDate birthDate;
    private String phone;


}