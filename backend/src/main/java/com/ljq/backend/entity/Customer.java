package com.ljq.backend.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private String id;         //客户ID
    private String name;        //客户姓名
    private String idCard;      //客户身份证
    private Integer gender;     //客户性别
    private Integer age;        //客户年龄
    private LocalDate birthDate;//客户出生年月
    private String phone;       //客户手机
    private String address;     //客户住址
    private Integer marriage;    //客户婚姻状态 0未婚 1已婚
}