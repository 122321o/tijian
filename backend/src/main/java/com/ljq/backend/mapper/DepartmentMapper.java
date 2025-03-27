package com.ljq.backend.mapper;

import com.github.pagehelper.Page;
import com.ljq.backend.dto.DepartmentPageQueryDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    /**
     * 科室分页查询
     * @param departmentPageQueryDTO
     * @return
     */
    Page<Department> pageQuery(DepartmentPageQueryDTO departmentPageQueryDTO);

    /**
     * 修改科室
     * @param department
     */
    void update(Department department);

    /**
     * 新增科室
     * @param department
     */
    void insert(Department department);

    /**
     * 根据id删除科室
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据id查询科室
     * @param id
     * @return
     */
    Department getById(Long id);


    List<Department> findAllDepartment();

    List<Department> findPageDepartment(PageDTO pageDTO);

    Department findByName(String name);

}
