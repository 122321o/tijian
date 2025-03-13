package com.ljq.backend.entity;

import lombok.Data;

@Data
public class Detail {
    private int id;
    private String name;
    private boolean gender;
    private Double price;
    private int departmentId;

}