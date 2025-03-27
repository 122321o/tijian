package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CombinationDTO;
import com.ljq.backend.dto.PackageDTO;
import com.ljq.backend.dto.PageDTO;

import java.util.List;

public interface PackageService {
    List<PackageDTO> findAllPackages();
    PageInfo<PackageDTO> findPagePackages(PageDTO pageDTO);
    void updatePackage(PackageDTO packageDTO);
    void deletePackage(Long id);
    void addPackage(PackageDTO packageDTO);
    List<CombinationDTO> findSelectedItems(Long packageId);
    List<CombinationDTO> findAvailableDetails(Long packageId);
    List<CombinationDTO> getCombinationsByPackageId(Long packageId);

}