package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.CombinationPageQueryDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.vo.DetailVO;

import java.util.List;

public interface CombinationService {

    /**
     * 组合分页查询
     * @param combinationPageQueryDTO
     * @return
     */
    PageResult page(CombinationPageQueryDTO combinationPageQueryDTO);

    /**
     * 组合修改
     * @param combinationDTO
     */
    void update(CombinationDTO combinationDTO);

    /**
     * 组合删除
     * @param id
     */
    void delete(Long id);

    /**
     * 组合新增
     * @param combinationDTO
     */
    void save(CombinationDTO combinationDTO);

    /**
     * 获取对应科室所有项目
     * @param combinationId
     * @return
     */
    List<DetailVO> findAvailableDetails(Long combinationId);

    List<DetailVO> findSelectedItems(Long combinationId);

}
