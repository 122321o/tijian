package com.ljq.backend.mapper;

import com.ljq.backend.dto.DetailUpdateDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    List<Detail> findAllDetail();

    List<PageDTO> findPageDetail(PageDTO pageDTO);

    void updateById(DetailUpdateDTO dto);

    void deleteById(Integer id);
}
