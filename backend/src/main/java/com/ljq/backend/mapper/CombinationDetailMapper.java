package com.ljq.backend.mapper;

import com.ljq.backend.entity.CombinationDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CombinationDetailMapper {
    // 批量插入关联
    void batchInsert(List<CombinationDetail> details);
    
    // 根据组合ID和项目ID列表删除关联
    void deleteByCombinationAndDetails(@Param("combinationId") Integer combinationId,
                                      @Param("detailIds") List<Integer> detailIds);
    
    // 查询组合的已关联项目ID列表
    List<Integer> findDetailIdsByCombinationId(@Param("combinationId") Integer combinationId);

}