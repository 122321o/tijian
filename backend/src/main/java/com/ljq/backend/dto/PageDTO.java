package com.ljq.backend.dto;

import lombok.Data;

@Data
public class PageDTO {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
