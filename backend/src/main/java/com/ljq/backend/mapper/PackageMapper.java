package com.ljq.backend.mapper;

import com.ljq.backend.dto.*;
import com.ljq.backend.dto.page.PageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PackageMapper {
    List<PackageDTO> findAllPackages();
    List<PackageDTO> findPagePackages(PageDTO pageDTO);
    void updatePackage(PackageDTO packageDTO);
    void deletePackage(Integer id);
    void addPackage(PackageDTO packageDTO);
    PackageDTO findById(Integer packageId);

    List<CombinationDTO> findSelectedItems(Integer packageId);
    List<CombinationDTO> findAvailableDetails(Integer packageId);

    List<CombinationDTO> getCombinationsByPackageId(Integer packageId);
}
