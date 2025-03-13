package com.ljq.backend.dto;

import lombok.Data;

@Data
public class CombinationPageDTO extends PageDTO {
    private Integer id;
    private String name;
    private Integer isActive;
    private String departmentName; // 科室名称（来自关联表）
    private Integer departmentId;
    private Integer gender;         // "男" 或 "女"
    private Double price;

}