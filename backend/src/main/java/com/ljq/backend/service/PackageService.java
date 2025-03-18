package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.PackageDTO;
import com.ljq.backend.dto.page.PageDTO;

import java.util.List;

public interface PackageService {
    List<PackageDTO> findAllPackages();
    PageInfo<PackageDTO> findPagePackages(PageDTO pageDTO);
    void updatePackage(PackageDTO packageDTO);
    void deletePackage(Integer id);
    void addPackage(PackageDTO packageDTO);
    List<CombinationDTO> findSelectedItems(Integer packageId);
    List<CombinationDTO> findAvailableDetails(Integer packageId);
    List<CombinationDTO> getCombinationsByPackageId(Integer packageId);

}