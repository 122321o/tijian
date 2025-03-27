package com.ljq.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class PackageCombinationUpdateDTO {
    private Long PackageId;
    private List<Long> CombinationIds;
}
