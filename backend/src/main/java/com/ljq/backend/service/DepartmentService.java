package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.DepartmentDTO;
import com.ljq.backend.dto.DepartmentPageQueryDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.result.PageResult;

import java.util.List;

public interface DepartmentService {



    /**
     * 科室分页查询
     * @param departmentPageQueryDTO
     * @return
     */
    PageResult pageQuery(DepartmentPageQueryDTO departmentPageQueryDTO);

    /**
     * 科室新增
     * @param departmentDTO
     */
    void save(DepartmentDTO departmentDTO);


    /**
     * 科室修改
     * @param departmentDTO
     */
    void update(DepartmentDTO departmentDTO);

    /**
     * 根据id删除科室
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据id查询科室
     * @param id
     */
    Department getById(Long id);




}
