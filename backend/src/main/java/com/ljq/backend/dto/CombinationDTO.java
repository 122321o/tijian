package com.ljq.backend.dto;

import lombok.Data;

@Data
public class CombinationDTO {
    private Long id;               // 项目编号
    private String name;              // 项目名称
    private Integer isActive;
    private String departmentName;    // 科室名称
    private Long departmentId;    // 科室编号
    private Integer gender;           // 性别
    private Double price;         // 单价
}
