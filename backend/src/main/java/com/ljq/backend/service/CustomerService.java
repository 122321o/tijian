package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.page.CustomerPageDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(Customer customer);
    int deleteCustomer(Integer id);
    int updateCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    List<Customer> findAllCustomer();
    PageInfo<Customer> findPageCustomer(PageDTO pageDTO);
}