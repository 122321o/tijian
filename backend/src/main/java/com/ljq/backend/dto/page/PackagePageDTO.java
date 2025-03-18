package com.ljq.backend.dto.page;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackagePageDTO extends PageDTO {
    private Integer id;
    private String name;
    private Integer isActive;
    private Integer gender;
    private BigDecimal price;
}