package com.ljq.backend.controller;

import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.CombinationPageQueryDTO;
import com.ljq.backend.result.Result;
import com.ljq.backend.dto.CombinationDetailUpdateDTO;
import com.ljq.backend.service.CombinationDetailService;
import com.ljq.backend.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/combination")
@RestController
public class CombinationController {

    @Autowired
    private CombinationService combinationService;

    @Autowired
    private CombinationDetailService combinationDetailService;

    /**
     * 组合分页查询
     * @param combinationPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result page(CombinationPageQueryDTO combinationPageQueryDTO) {
        return Result.success(combinationService.page(combinationPageQueryDTO));
    }

    /**
     * 组合修改
     * @param combinationDTO
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody CombinationDTO combinationDTO) {
        combinationService.update(combinationDTO);
        return Result.success();
    }

    /**
     * 组合删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Long id) {
        combinationService.delete(id);
        return Result.success();
    }

    /**
     * 组合新增
     * @param combinationDTO
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody CombinationDTO combinationDTO) {
        combinationService.save(combinationDTO);
        return Result.success();
    }


    /**
     * 根据组合id获取相同科室的所有明细项目
     * @param id
     * @return
     */
    @GetMapping("/loadAvailableItems/{id}")
    public Result loadAvailableItems(@PathVariable Long id) {
        return Result.success(combinationService.findAvailableDetails(id));
    }

    /**
     * 获取对应组合已选项目
     * @param id
     * @return
     */
    @GetMapping("/loadSelectedItems/{id}")
    public Result loadSelectedItems(@PathVariable Long id) {
        return Result.success(combinationService.findSelectedItems(id));
    }

    /**
     * 组合明细关系更新
     * @param payload
     * @return
     */
    @PostMapping("/updateSelectedDetails")
    public Result updateSelectedDetails(@RequestBody CombinationDetailUpdateDTO payload) {
        combinationDetailService.updateSelectedDetails(payload.getCombinationId(), payload.getDetailIds());
        return Result.success();
    }
}
