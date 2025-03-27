package com.ljq.backend.service;

import java.util.List;

public interface CombinationDetailService {
    void updateSelectedDetails(Long combinationId, List<Long> newDetailIds);
}