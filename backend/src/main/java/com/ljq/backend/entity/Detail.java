package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Detail {
    private Integer id;
    private String name;
    private boolean gender;
    private BigDecimal price;
    private Integer departmentId;

}