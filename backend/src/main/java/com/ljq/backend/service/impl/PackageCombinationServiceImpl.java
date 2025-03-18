package com.ljq.backend.service.impl;

import com.ljq.backend.entity.CombinationDetail;
import com.ljq.backend.entity.PackageCombination;
import com.ljq.backend.mapper.CombinationDetailMapper;
import com.ljq.backend.mapper.PackageCombinationMapper;
import com.ljq.backend.service.CombinationDetailService;
import com.ljq.backend.service.PackageCombinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PackageCombinationServiceImpl implements PackageCombinationService {
    private final PackageCombinationMapper packageCombinationMapper;

    public void updateSelectedCombinations(Integer packageId, List<Integer> newCombinationIds) {
        // 1. 校验参数，使用局部变量存储 newCombinationIds
        List<Integer> combinationIds = (newCombinationIds == null) ? Collections.emptyList() : newCombinationIds;
        // 2. 查询旧的项目ID列表
        List<Integer> oldCombinations = packageCombinationMapper.findCombinationIdsByPackageId(packageId);

        // 3. 计算需要删除的项（旧列表存在，新列表不存在）
        List<Integer> toDelete = oldCombinations.stream()
                .filter(id -> !combinationIds.contains(id)) // 使用局部变量 combinationIds
                .collect(Collectors.toList());

        // 4. 计算需要新增的项（新列表存在，旧列表不存在）
        List<Integer> toAdd = combinationIds.stream() // 使用局部变量 combinationIds
                .filter(id -> !oldCombinations.contains(id))
                .collect(Collectors.toList());
        // 5. 执行删除和新增
        if (!toDelete.isEmpty()) {
            packageCombinationMapper.deleteByCombinationAndDetails(packageId, toDelete);
        }
        if (!toAdd.isEmpty()) {
            List<PackageCombination> addList = toAdd.stream()
                    .map(combinationId -> new PackageCombination(packageId, combinationId))
                    .collect(Collectors.toList());
            packageCombinationMapper.batchInsert(addList);
        }
    }
}