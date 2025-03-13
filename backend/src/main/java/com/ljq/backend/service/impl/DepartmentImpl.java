package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }

    @Override
    public PageInfo<Department> findPageDepartment(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(departmentMapper.findPageDepartment(pageDTO));
    }

    @Override
    public void update(Department department) {
        departmentMapper.updateById(department);
    }

    @Override
    public void delete(Integer id) {
        departmentMapper.deleteById(id);
    }
}
