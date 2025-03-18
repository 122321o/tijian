package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.PackageDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.mapper.PackageMapper;
import com.ljq.backend.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {
    private final PackageMapper packageMapper;

    @Override
    public List<PackageDTO> findAllPackages() {
        return packageMapper.findAllPackages();
    }

    @Override
    public PageInfo<PackageDTO> findPagePackages(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(packageMapper.findPagePackages(pageDTO));
    }

    @Override
    public void updatePackage(PackageDTO packageDTO) {
        packageMapper.updatePackage(packageDTO);
    }

    @Override
    public void deletePackage(Integer id) {
        packageMapper.deletePackage(id);
    }

    @Override
    public void addPackage(PackageDTO packageDTO) {
        packageMapper.addPackage(packageDTO);
    }

    @Override
    public List<CombinationDTO> findSelectedItems(Integer packageId) {
        // 1. 根据组合 ID 查找套餐信息
        PackageDTO packageDTO = packageMapper.findById(packageId);
        if (packageDTO == null) {
            throw new RuntimeException("套餐不存在");
        }

        // 2. 查找符合条件的明细查找已关联的
        return packageMapper.findSelectedItems(packageId);
    }

    @Override
    public List<CombinationDTO> findAvailableDetails(Integer packageId) {
        // 1. 根据组合 ID 查找套餐信息
        PackageDTO packageDTO = packageMapper.findById(packageId);
        if (packageDTO == null) {
            throw new RuntimeException("套餐不存在");
        }

        // 2. 查找符合条件的明细查找已关联的
        return packageMapper.findAvailableDetails(packageId);
    }

    @Override
    public List<CombinationDTO> getCombinationsByPackageId(Integer packageId) {
        return packageMapper.getCombinationsByPackageId(packageId);
    }
}