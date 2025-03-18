package com.ljq.backend.mapper;

import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> findAllDepartment();

    List<Department> findPageDepartment(PageDTO pageDTO);

    void updateById(Department department);

    void deleteById(Integer id);

    Department findById(Integer id);

    Department findByName(String name);

    void insert(Department department);
}
