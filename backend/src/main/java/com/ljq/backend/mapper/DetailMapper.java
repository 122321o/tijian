package com.ljq.backend.mapper;

import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    List<Detail> findAllDetail();

    List<PageDTO> findPageDetail(PageDTO pageDTO);

    void updateById(DetailDTO dto);

    void deleteById(Integer id);

    void insert(Detail detail);
}
