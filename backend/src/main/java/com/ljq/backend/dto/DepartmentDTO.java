package com.ljq.backend.dto;

import lombok.Data;

@Data
public class DepartmentDTO{
    //编号
    private Long id;
    //科室名称
    private String name;
    //科室状态
    private Integer isActive;

}