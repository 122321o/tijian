package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationPageDTO;
import com.ljq.backend.dto.CombinationUpdateDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.dto.request.CombinationRequest;
import com.ljq.backend.entity.Department;
import com.ljq.backend.entity.Combination;
import com.ljq.backend.entity.Detail;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.mapper.CombinationMapper;
import com.ljq.backend.mapper.DetailMapper;
import com.ljq.backend.service.CombinationService;
import com.ljq.backend.service.CombinationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinationServiceImpl implements CombinationService {

    @Autowired
    private CombinationMapper combinationMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<Combination> findAllCombination() {
        return combinationMapper.findAllCombination();
    }

    @Override
    public PageInfo<PageDTO> findPageCombination(CombinationRequest request) {
        CombinationPageDTO pageDTO = new CombinationPageDTO();
        BeanUtils.copyProperties(request, pageDTO);
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(combinationMapper.findPageCombination(pageDTO));
    }

    @Override
    public void update(CombinationRequest request) {
        Department department = departmentMapper.findByName(request.getDepartmentName());
        if (department == null) {
            throw new RuntimeException("科室名称不存在");
        }
        CombinationUpdateDTO dto = new CombinationUpdateDTO();
        BeanUtils.copyProperties(request, dto);
        dto.setDepartmentId(department.getId());
        combinationMapper.updateById(dto);
    }

    @Override
    public void delete(Integer id) {
        combinationMapper.deleteById(id);
    }

    @Override
    public List<Detail> findAvailableDetails(Integer id) {
        // 1. 根据组合 ID 查找组合信息
        Combination combination = combinationMapper.findById(id);
        if (combination == null) {
            throw new RuntimeException("组合不存在");
        }
        System.out.println(combination);
        System.out.println(combination.getDepartmentId());

        // 2. 查找符合条件的明细并排除已关联的
        return combinationMapper.findAvailableDetails(combination.getDepartmentId(),id);
    }
}
