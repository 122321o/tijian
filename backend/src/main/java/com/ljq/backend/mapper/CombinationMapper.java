package com.ljq.backend.mapper;

import com.github.pagehelper.Page;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Combination;
import com.ljq.backend.vo.CombinationVO;
import com.ljq.backend.vo.DetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CombinationMapper {

    /**
     * 组合分页查询
     * @param combination
     * @return
     */
    Page<CombinationVO> page(Combination combination);

    /**
     * 组合修改
     * @param combination
     */
    void update(Combination combination);

    /**
     * 组合删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id获取组合信息
     * @param id
     * @return
     */
    Combination getById(Long id);

    /**
     * 组合新增
     * @param combination
     */
    void insert(Combination combination);


    List<DetailVO> findAvailableDetails(Long departmentId, Long combinationId);

    List<DetailVO> findSelectedItems(Long departmentId, Long combinationId);

}
