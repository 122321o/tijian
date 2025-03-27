package com.ljq.backend.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombinationVO {
    private Long id;
    private String name;
    private Long departmentId;
    private Integer gender;
    private BigDecimal price;
    private Integer isActive;
    private String departmentName;
}
