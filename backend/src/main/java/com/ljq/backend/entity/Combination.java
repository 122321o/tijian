package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Combination {
    private Integer id;
    private String name;
    private Integer isActive;
    private Integer gender;
    private BigDecimal price;
    private Integer departmentId;

}