package com.ljq.backend.dto;

import lombok.Data;

@Data
public class PageDTO {
    //页码
    private Integer pageNum = 1;
    //每页显示记录数
    private Integer pageSize = 10;
}
