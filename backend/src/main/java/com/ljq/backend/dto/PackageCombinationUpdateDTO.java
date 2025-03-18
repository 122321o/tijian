package com.ljq.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class PackageCombinationUpdateDTO {
    private Integer PackageId;
    private List<Integer> CombinationIds;
}
