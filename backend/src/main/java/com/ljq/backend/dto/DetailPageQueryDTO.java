package com.ljq.backend.dto;

import lombok.Data;

@Data
public class DetailPageQueryDTO extends PageDTO {
    private Long id;
    private String name;
    private String departmentName; // 科室名称（来自关联表）
    private Long departmentId;
    private Integer gender;         // "男" 或 "女"
    private Double price;

}