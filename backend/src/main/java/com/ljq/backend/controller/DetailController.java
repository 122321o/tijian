package com.ljq.backend.controller;

import com.ljq.backend.common.Result;
import com.ljq.backend.dto.request.DetailRequest;
import com.ljq.backend.entity.Detail;
import com.ljq.backend.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/detail")
@RestController
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/findAll")
    public Result findAllDetail() {
        return Result.success(detailService.findAllDetail());
    }

    @PostMapping("/findPage")
    public Result findPageDetail(@RequestBody DetailRequest request) {
        return Result.success(detailService.findPageDetail(request));
    }

    @PostMapping("/update")
    public Result updateById(@RequestBody DetailRequest request) {
        detailService.update(request);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        detailService.delete(id);
        return Result.success();
    }

    // 新增明细
    @PostMapping("/add")
    public Result addDepartment(@RequestBody Detail detail) {
        detailService.addDetail(detail);
        return Result.success();
    }
}
