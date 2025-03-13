package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.dto.request.CombinationRequest;
import com.ljq.backend.entity.Combination;
import com.ljq.backend.entity.Detail;

import java.util.List;

public interface CombinationService {

    List<Combination> findAllCombination();

    PageInfo<PageDTO> findPageCombination(CombinationRequest request);

    void update(CombinationRequest request);

    void delete(Integer id);

    List<Detail> findAvailableDetails(Integer id);
}
