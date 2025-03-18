package com.ljq.backend.controller;

import com.ljq.backend.common.Result;
import com.ljq.backend.dto.page.DepartmentPageDTO;
import com.ljq.backend.entity.Department;
import com.ljq.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findAll")
    public Result findAllDepartment() {
        return Result.success(departmentService.findAllDepartment());
    }

    @PostMapping("/findPage")
    public Result findPageDepartment(@RequestBody DepartmentPageDTO departmentPageDTO) {
        return Result.success(departmentService.findPageDepartment(departmentPageDTO));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody Department department) {
        departmentService.update(department);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        departmentService.delete(id);
        return Result.success();
    }

    @PostMapping("/add")
    public Result addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return Result.success();
    }

}
