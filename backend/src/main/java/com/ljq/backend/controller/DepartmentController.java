package com.ljq.backend.controller;

import com.ljq.backend.dto.DepartmentDTO;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.result.Result;
import com.ljq.backend.dto.DepartmentPageQueryDTO;
import com.ljq.backend.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 科室分页查询
     * @param departmentPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(DepartmentPageQueryDTO departmentPageQueryDTO) {
        log.info("分页查询：{}", departmentPageQueryDTO);
        PageResult pageResult = departmentService.pageQuery(departmentPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改科室
     * @param departmentDTO
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody DepartmentDTO departmentDTO) {
        log.info("修改科室：{}", departmentDTO);
        departmentService.update(departmentDTO);
        return Result.success();
    }

    /**
     * 新增科室
     * @param departmentDTO
     * @return
     */
    @PostMapping
    public Result save(@RequestBody DepartmentDTO departmentDTO) {
        log.info("新增科室：{}", departmentDTO);
        departmentService.save(departmentDTO);
        return Result.success();
    }

    /**
     * 根据id删除科室
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
        return Result.success();
    }


}
