package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Package {
    private int id;
    private String name;
    private boolean gender;
    private BigDecimal price;

}