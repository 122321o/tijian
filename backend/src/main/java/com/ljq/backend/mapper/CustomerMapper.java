package com.ljq.backend.mapper;

import com.ljq.backend.dto.CustomerPageDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insert(Customer customer);
    int deleteById(String id);
    int updateById(Customer customer);
    Customer selectById(String id);
    List<Customer> selectAll();
    List<CustomerPageDTO> findPageCustomer(PageDTO pageDTO);
    String getMaxCustomerIdByDate(@Param("datePrefix") String datePrefix);
}
