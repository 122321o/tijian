package com.ljq.backend.mapper;

import com.ljq.backend.entity.PackageCombination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PackageCombinationMapper {
    // 批量插入关联
    void batchInsert(List<PackageCombination> combinations);
    
    // 根据套餐ID和组合ID列表删除关联
    void deleteByCombinationAndDetails(@Param("packageId") Integer packageId,
                                      @Param("combinationIds") List<Integer> combinationIds);
    
    // 查询组合的已关联项目ID列表
    List<Integer> findCombinationIdsByPackageId(@Param("packageId") Integer packageId);

}