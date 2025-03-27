package com.ljq.backend.service;

import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.DetailPageQueryDTO;
import com.ljq.backend.result.PageResult;

public interface DetailService {

    /**
     * 明细分页查询
     * @param detailPageQueryDTO
     * @return
     */
    PageResult pageQuery(DetailPageQueryDTO detailPageQueryDTO);

    /**
     * 明细修改
     * @param detailDTO
     */
    void update(DetailDTO detailDTO);

    /**
     * 明细删除
     * @param id
     */
    void delete(Long id);

    /**
     * 明细新增
     * @param detailDTO
     */
    void save(DetailDTO detailDTO);
}
