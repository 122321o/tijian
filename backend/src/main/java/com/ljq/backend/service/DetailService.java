package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.dto.request.DetailRequest;
import com.ljq.backend.entity.Detail;

import java.util.List;

public interface DetailService {

    List<Detail> findAllDetail();

    PageInfo<PageDTO> findPageDetail(DetailRequest request);

    void update(DetailRequest request);

    void delete(Integer id);

    void addDetail(Detail detail);
}
