package com.ljq.backend.mapper;

import com.ljq.backend.dto.CombinationUpdateDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Combination;
import com.ljq.backend.entity.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CombinationMapper {
    List<Combination> findAllCombination();

    List<PageDTO> findPageCombination(PageDTO pageDTO);

    void updateById(CombinationUpdateDTO dto);

    void deleteById(Integer id);

    Combination findById(Integer id);

    List<Detail> findAvailableDetails(Integer departmentId, Integer combinationId);
}
