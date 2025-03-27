package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Registration {
    private Long id; //体检编号
    private Long packageId;  //套餐ID
    private BigDecimal price;  //套餐价格
    private LocalDateTime checkinTime;  //检查时间
    private Integer status; //判断检查状态 1在检 2检查完成
}