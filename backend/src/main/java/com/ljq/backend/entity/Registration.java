package com.ljq.backend.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Registration {
    private Integer id;
    private Integer customerId;
    private Integer packageId;
    private Double totalPrice;
    private LocalDateTime checkinTime;
    private boolean status;


}