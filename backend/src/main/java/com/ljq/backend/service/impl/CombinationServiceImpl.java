package com.ljq.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationPageQueryDTO;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.entity.Combination;
import com.ljq.backend.exception.BusinessException;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.mapper.CombinationMapper;
import com.ljq.backend.mapper.DetailMapper;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.service.CombinationService;
import com.ljq.backend.vo.CombinationVO;
import com.ljq.backend.vo.DetailVO;
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

    /**
     * 组合分页查询
     *
     * @param combinationPageQueryDTO
     * @return
     */
    public PageResult page(CombinationPageQueryDTO combinationPageQueryDTO) {
        PageHelper.startPage(combinationPageQueryDTO.getPageNum(), combinationPageQueryDTO.getPageSize());
        Combination combination = new Combination();
        BeanUtils.copyProperties(combinationPageQueryDTO, combination);
        Page<CombinationVO> page = combinationMapper.page(combination);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 组合修改
     *
     * @param combinationDTO
     */
    public void update(CombinationDTO combinationDTO) {
        Department department = departmentMapper.findByName(combinationDTO.getDepartmentName());

        if (department == null) {
            throw new RuntimeException("科室名称不存在");
        }
        // 数据库中查询组合
        Combination combination1 = combinationMapper.getById(combinationDTO.getId());
        // 判断组合的科室是否有修改
        if (combination1.getDepartmentId() != combinationDTO.getDepartmentId()) {
            List<DetailVO> selectedItems = combinationMapper.findSelectedItems(combination1.getDepartmentId(), combinationDTO.getId());
            //判断是否已选明细项目，如果已选，不允许修改
            if (selectedItems.size() > 0) {
                throw new BusinessException("该组合已选择明细项，不允许修改科室");
            }
        }

        Combination combination = new Combination();
        BeanUtils.copyProperties(combinationDTO, combination);
        combination.setDepartmentId(department.getId());
        combinationMapper.update(combination);
    }

    /**
     * 组合新增
     *
     * @param combinationDTO
     */
    public void save(CombinationDTO combinationDTO) {
        Combination combination = new Combination();
        BeanUtils.copyProperties(combinationDTO, combination);
        combinationMapper.insert(combination);
    }

    /**
     * 组合删除
     *
     * @param id
     */
    public void delete(Long id) {
        combinationMapper.delete(id);
    }

    /**
     * 获取对应科室所有项目
     *
     * @param combinationId
     * @return
     */
    public List<DetailVO> findAvailableDetails(Long combinationId) {
        // 1. 根据组合 ID 查找组合信息
        Combination combination = combinationMapper.getById(combinationId);
        if (combination == null) {
            throw new BusinessException("组合不存在");
        }

        // 2. 查找符合条件的明细并排除已关联的
        return combinationMapper.findAvailableDetails(combination.getDepartmentId(), combinationId);
    }

    /**
     * 根据组合Id获取该组合的所有明细项目,返回所有明细项目
     *
     * @param combinationId
     * @return
     */
    public List<DetailVO> findSelectedItems(Long combinationId) {
        // 1. 根据组合 ID 查找组合信息
        Combination combination = combinationMapper.getById(combinationId);
        if (combination == null) {
            throw new BusinessException("组合不存在");
        }

        // 2. 查找符合条件的明细查找已关联的
        return combinationMapper.findSelectedItems(combination.getDepartmentId(), combinationId);

    }



}
