package com.ljq.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.DepartmentDTO;
import com.ljq.backend.dto.DepartmentPageQueryDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 科室分页查询
     * @param departmentPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DepartmentPageQueryDTO departmentPageQueryDTO) {
        PageHelper.startPage(departmentPageQueryDTO.getPageNum(),departmentPageQueryDTO.getPageSize());
        Page<Department> page = departmentMapper.pageQuery(departmentPageQueryDTO);
        long total = page.getTotal();
        List<Department> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 科室修改
     * @param departmentDTO
     */
    public void update(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        departmentMapper.update(department);
    }

    /**
     * 科室新增
     * @param departmentDTO
     */
    public void save(DepartmentDTO departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        departmentMapper.insert(department);
    }

    /**
     * 根据id删除科室
     * @param id
     */
    public void deleteById(Long id) {
        departmentMapper.deleteById(id);
    }

    /**
     * 根据id查询科室
     * @param id
     */
    public Department getById(Long id) {
        return departmentMapper.getById(id);
    }

    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }



}
