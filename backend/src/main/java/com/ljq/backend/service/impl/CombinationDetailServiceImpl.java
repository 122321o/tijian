package com.ljq.backend.service.impl;

import com.ljq.backend.entity.CombinationDetail;
import com.ljq.backend.mapper.CombinationDetailMapper;
import com.ljq.backend.service.CombinationDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CombinationDetailServiceImpl implements CombinationDetailService {
    private final CombinationDetailMapper combinationDetailMapper;

    public void updateSelectedDetails(Long combinationId, List<Long> newDetailIds) {
        // 1. 校验参数，使用局部变量存储 newDetailIds
        List<Long> detailIds = (newDetailIds == null) ? Collections.emptyList() : newDetailIds;

        // 2. 查询旧的项目ID列表
        List<Long> oldDetailIds = combinationDetailMapper.findCombinationIdsByPackageId(combinationId);

        // 3. 计算需要删除的项（旧列表存在，新列表不存在）
        List<Long> toDelete = oldDetailIds.stream()
                .filter(id -> !detailIds.contains(id)) // 使用局部变量 detailIds
                .collect(Collectors.toList());

        // 4. 计算需要新增的项（新列表存在，旧列表不存在）
        List<Long> toAdd = detailIds.stream() // 使用局部变量 detailIds
                .filter(id -> !oldDetailIds.contains(id))
                .collect(Collectors.toList());

        // 5. 执行删除和新增
        if (!toDelete.isEmpty()) {
            combinationDetailMapper.deleteByCombinationAndDetails(combinationId, toDelete);
        }
        if (!toAdd.isEmpty()) {
            List<CombinationDetail> addList = toAdd.stream()
                    .map(detailId -> new CombinationDetail(combinationId, detailId))
                    .collect(Collectors.toList());
            combinationDetailMapper.batchInsert(addList);
        }
    }
}