package com.ljq.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackagePageQueryDTO extends PageDTO {
    private Integer id;
    private String name;
    private Integer isActive;
    private Integer gender;
    private BigDecimal price;
}