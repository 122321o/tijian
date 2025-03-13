package com.ljq.backend.dto;

import lombok.Data;

@Data
public class DepartmentPageDTO extends PageDTO {
    private Integer id;
    private String name;
    private Integer isActive;
}
