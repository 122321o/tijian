package com.ljq.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ljq.backend.dto.DetailPageQueryDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.entity.Detail;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.mapper.DetailMapper;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.service.DetailService;
import com.ljq.backend.vo.DetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 明细分页查询
     * @param detailPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DetailPageQueryDTO detailPageQueryDTO) {
        PageHelper.startPage(detailPageQueryDTO.getPageNum(),detailPageQueryDTO.getPageSize());
        Page<DetailVO> page = detailMapper.pageQuery(detailPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 修改明细
     * @param detailDTO
     */
    public void update(DetailDTO detailDTO) {
        //判断科室名称存在
        Department department = departmentMapper.findByName(detailDTO.getDepartmentName());
        if (department == null) {
            throw new RuntimeException("科室名称不存在");
        }

        Detail detail = new Detail();
        BeanUtils.copyProperties(detailDTO,detail);
        //设置明细的科室id
        detail.setDepartmentId(department.getId());
        detailMapper.update(detail);
    }

    /**
     * 明细删除
     * @param id
     */
    public void delete(Long id) {
        detailMapper.deleteById(id);
    }

    /**
     * 明细新增
     * @param detailDTO
     */
    public void save(DetailDTO detailDTO) {
        Detail detail = new Detail();
        BeanUtils.copyProperties(detailDTO,detail);
        detailMapper.insert(detail);
    }
}
