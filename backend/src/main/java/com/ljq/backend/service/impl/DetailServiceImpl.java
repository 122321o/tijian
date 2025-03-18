package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.page.DetailPageDTO;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.dto.request.DetailRequest;
import com.ljq.backend.entity.Department;
import com.ljq.backend.entity.Detail;
import com.ljq.backend.mapper.DepartmentMapper;
import com.ljq.backend.mapper.DetailMapper;
import com.ljq.backend.service.DetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Detail> findAllDetail() {
        return detailMapper.findAllDetail();
    }

    @Override
    public PageInfo<PageDTO> findPageDetail(DetailRequest request) {
        DetailPageDTO pageDTO = new DetailPageDTO();
        BeanUtils.copyProperties(request, pageDTO);
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(detailMapper.findPageDetail(pageDTO));
    }

    @Override
    public void update(DetailRequest request) {
        Department department = departmentMapper.findByName(request.getDepartmentName());
        if (department == null) {
            throw new RuntimeException("科室名称不存在");
        }
        DetailDTO dto = new DetailDTO();
        BeanUtils.copyProperties(request, dto);
        dto.setDepartmentId(department.getId());
        detailMapper.updateById(dto);
    }

    @Override
    public void delete(Integer id) {
        detailMapper.deleteById(id);
    }

    @Override
    public void addDetail(Detail detail) {
        detailMapper.insert(detail);
    }
}
