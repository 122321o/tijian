package com.ljq.backend.service;

import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.page.CustomerPageDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(Customer customer);
    int deleteCustomer(String id);
    int updateCustomer(Customer customer);
    Customer getCustomerById(String id);
    List<Customer> findAllCustomer();
    PageInfo<CustomerPageDTO> findPageCustomer(PageDTO pageDTO);
    String generateCustomerId();
}