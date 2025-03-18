package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.dto.request.CombinationRequest;
import com.ljq.backend.entity.Combination;

import java.util.List;

public interface CombinationService {

    List<Combination> findAllCombination();

    PageInfo<PageDTO> findPageCombination(CombinationRequest request);

    void update(CombinationRequest request);

    void delete(Integer id);

    List<DetailDTO> findAvailableDetails(Integer combinationId);

    List<DetailDTO> findSelectedItems(Integer combinationId);

    void add(Combination combination);
}
