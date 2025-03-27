package com.ljq.backend.mapper;

import com.ljq.backend.dto.*;
import com.ljq.backend.dto.PageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PackageMapper {
    List<PackageDTO> findAllPackages();
    List<PackageDTO> findPagePackages(PageDTO pageDTO);
    void updatePackage(PackageDTO packageDTO);
    void deletePackage(Long id);
    void addPackage(PackageDTO packageDTO);
    PackageDTO findById(Long packageId);

    List<CombinationDTO> findSelectedItems(Long packageId);
    List<CombinationDTO> findAvailableDetails(Long packageId);

    List<CombinationDTO> getCombinationsByPackageId(Long packageId);
}
