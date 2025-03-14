package com.ljq.backend.entity;

import lombok.Data;

@Data
public class Detail {
    private Integer id;
    private String name;
    private boolean gender;
    private Double price;
    private Integer departmentId;

}