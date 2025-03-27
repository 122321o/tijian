package com.ljq.backend.service;

import java.util.List;

public interface PackageCombinationService {
    void updateSelectedCombinations(Long packageId, List<Long> newCombinationIds);
}