package com.ljq.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CombinationDetailUpdateDTO {
    private Long combinationId;
    private List<Long> detailIds;
}