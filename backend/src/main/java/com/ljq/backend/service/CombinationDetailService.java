package com.ljq.backend.service;

import java.util.List;

public interface CombinationDetailService {
    void updateSelectedDetails(Integer combinationId, List<Integer> newDetailIds);
}