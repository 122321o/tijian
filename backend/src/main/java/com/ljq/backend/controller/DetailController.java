package com.ljq.backend.controller;

import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.DetailPageQueryDTO;
import com.ljq.backend.result.PageResult;
import com.ljq.backend.result.Result;
import com.ljq.backend.service.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/detail")
@RestController
@Slf4j
public class DetailController {

    @Autowired
    private DetailService detailService;

    /**
     * 明细分页查询
     * @param detailPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(DetailPageQueryDTO detailPageQueryDTO) {
        log.info("分页查询：{}", detailPageQueryDTO);
        PageResult pageResult = detailService.pageQuery(detailPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改明细
     * @param detailDTO
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody DetailDTO detailDTO) {
        log.info("明细修改：{}", detailDTO);
        detailService.update(detailDTO);
        return Result.success();
    }

    /**
     * 删除明细
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Long id) {
        detailService.delete(id);
        return Result.success();
    }

    /**
     * 明细新增
     * @param detailDTO
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody DetailDTO detailDTO) {
        log.info("新增明细：{}", detailDTO);
        detailService.save(detailDTO);
        return Result.success();
    }
}
