package com.ljq.backend.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String idCard;
    private Integer gender;
    private LocalDate birthDate;
    private String phone;


}