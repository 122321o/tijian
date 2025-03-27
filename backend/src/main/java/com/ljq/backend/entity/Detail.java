package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Detail {
    private Long id;
    private String name;
    private boolean gender;
    private BigDecimal price;
    private Long departmentId;

}