package com.ljq.backend.controller;

import com.ljq.backend.common.Result;
import com.ljq.backend.dto.request.CombinationRequest;
import com.ljq.backend.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/combination")
@RestController
public class CombinationController {

    @Autowired
    private CombinationService combinationService;

    @GetMapping("/findAll")
    public Result findAllCombination() {
        return Result.success(combinationService.findAllCombination());
    }

    @PostMapping("/findPage")
    public Result findPageCombination(@RequestBody CombinationRequest request) {
        return Result.success(combinationService.findPageCombination(request));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody CombinationRequest request) {
        combinationService.update(request);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        combinationService.delete(id);
        return Result.success();
    }

    //根据组合id获取相同科室的所有明细项目
    @GetMapping("/loadItem/{id}")
    public Result getDetailById(@PathVariable Integer id) {
        return Result.success(combinationService.findAvailableDetails(id));
    }
}
