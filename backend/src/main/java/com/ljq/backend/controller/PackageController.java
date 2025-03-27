package com.ljq.backend.controller;

import com.ljq.backend.result.Result;
import com.ljq.backend.dto.PackageCombinationUpdateDTO;
import com.ljq.backend.dto.PackageDTO;
import com.ljq.backend.dto.PackagePageQueryDTO;
import com.ljq.backend.service.PackageCombinationService;
import com.ljq.backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @Autowired
    private PackageCombinationService packageCombinationService;

    @GetMapping("/findAll")
    public Result findAllPackages() {
        return Result.success(packageService.findAllPackages());
    }

    @PostMapping("/findPage")
    public Result findPagePackages(@RequestBody PackagePageQueryDTO packageDTO) {
        return Result.success(packageService.findPagePackages(packageDTO));
    }

    @PostMapping("/update")
    public Result updatePackage(@RequestBody PackageDTO packageDTO) {
        packageService.updatePackage(packageDTO);
        return Result.success();
    }

    @PostMapping("/delete/{id}")
    public Result deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return Result.success();
    }

    @PostMapping("/add")
    public Result addPackage(@RequestBody PackageDTO packageDTO) {
        packageService.addPackage(packageDTO);
        return Result.success();
    }

    @GetMapping("/loadSelectedItems/{id}")
    public Result loadSelectedItems(@PathVariable Long id) {
        return Result.success(packageService.findSelectedItems(id));
    }

    @GetMapping("/loadAvailableItems/{id}")
    public Result loadAvailableItems(@PathVariable Long id) {
        return Result.success(packageService.findAvailableDetails(id));
    }

    @PostMapping("/updateSelectedCombination")
    public Result updateSelectedDetails(@RequestBody PackageCombinationUpdateDTO payload) {
        packageCombinationService.updateSelectedCombinations(payload.getPackageId(), payload.getCombinationIds());
        return Result.success();
    }

    @GetMapping("/details/{id}")
    public Result getCombinationsByPackageId(@PathVariable Long id) {
        return Result.success(packageService.getCombinationsByPackageId(id));
    }
}