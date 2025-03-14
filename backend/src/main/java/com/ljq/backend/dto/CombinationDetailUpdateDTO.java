package com.ljq.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CombinationDetailUpdateDTO {
    private Integer combinationId;
    private List<Integer> detailIds;
}