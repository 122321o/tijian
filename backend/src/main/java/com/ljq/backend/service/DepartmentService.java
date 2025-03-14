package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment();

    PageInfo<Department> findPageDepartment(PageDTO pageDTO);

    void update(Department department);

    void delete(Integer id);

    void addDepartment(Department department);
}
