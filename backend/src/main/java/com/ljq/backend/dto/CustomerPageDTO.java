package com.ljq.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CustomerPageDTO extends PageDTO {
    private String id;         //客户ID
    private String name;        //客户姓名
    private String idCard;      //客户身份证
    private Long gender;     //客户性别
    private Long age;        //客户年龄
    private LocalDate birthDate;//客户出生年月
    private String phone;       //客户手机
    private String address;     //客户住址
    private Long marriage;    //客户婚姻状态 0未婚 1已婚
    private Long packageId;  //套餐ID
    private String packageName; //套餐名称
    private BigDecimal price;  //套餐价格
    private LocalDateTime checkinTime;  //检查时间
    private LocalDateTime startDate;  //搜索条件 检查开始时间
    private LocalDateTime endDate;  //搜索条件 检查结束时间
    private Long status; //判断检查状态 1在检 2检查完成
}