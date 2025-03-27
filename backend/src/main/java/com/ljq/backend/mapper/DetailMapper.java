package com.ljq.backend.mapper;

import com.github.pagehelper.Page;
import com.ljq.backend.dto.DetailDTO;
import com.ljq.backend.dto.DetailPageQueryDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Detail;
import com.ljq.backend.vo.DetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {

    /**
     * 明细分页查询
     * @param detailPageQueryDTO
     * @return
     */
    Page<DetailVO> pageQuery(DetailPageQueryDTO detailPageQueryDTO);

    /**
     * 修改明细
     * @param detail
     */
    void update(Detail detail);

    /**
     * 删除明细
     * @param id
     */
    void deleteById(Long id);

    /**
     * 新增明细
     * @param detail
     */
    void insert(Detail detail);
}
