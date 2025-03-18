package com.ljq.backend.mapper;

import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Combination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CombinationMapper {
    List<Combination> findAllCombination();

    List<PageDTO> findPageCombination(PageDTO pageDTO);

    void updateById(CombinationDTO dto);

    void deleteById(Integer id);

    Combination findById(Integer id);

    List<DetailDTO> findAvailableDetails(Integer departmentId, Integer combinationId);

    List<DetailDTO> findSelectedItems(Integer departmentId, Integer combinationId);

    void insert(Combination combination);
}
