package com.ljq.backend.service;

import java.util.List;

public interface PackageCombinationService {
    void updateSelectedCombinations(Integer packageId, List<Integer> newCombinationIds);
}