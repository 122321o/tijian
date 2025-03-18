package com.ljq.backend.mapper;

import com.ljq.backend.dto.page.CustomerPageDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Customer;
import com.ljq.backend.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insert(Customer customer);
    int deleteById(Integer id);
    int updateById(Customer customer);
    Customer selectById(Integer id);
    List<Customer> selectAll();
    List<Customer> findPageCustomer(PageDTO pageDTO);
}
