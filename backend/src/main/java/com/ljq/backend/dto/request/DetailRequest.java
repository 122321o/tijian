package com.ljq.backend.dto.request;

import lombok.Data;

@Data
public class DetailRequest extends BaseRequest {
    private Integer id;               // 项目编号
    private String name;              // 项目名称
    private String departmentName;    // 科室名称
    private Integer departmentId;    // 科室编号
    private Integer gender;           // 性别
    private Double price;         // 单价
}