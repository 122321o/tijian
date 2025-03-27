package com.ljq.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CombinationPageQueryDTO extends PageDTO {
    private Long id;
    private String name;
    private Integer isActive;
    private String departmentName; // 科室名称（来自关联表）
    private Long departmentId;
    private Integer gender;         // "男" 或 "女"
    private BigDecimal price;

}