package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.page.CustomerPageDTO;
import com.ljq.backend.dto.page.PageDTO;
import com.ljq.backend.entity.Customer;
import com.ljq.backend.exception.BusinessException;
import com.ljq.backend.mapper.CustomerMapper;
import com.ljq.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

// src/main/java/com/example/demo/service/impl/CustomerServiceImpl.java
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    private void validateCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new BusinessException("客户姓名不能为空");
        }
        if (customer.getIdCard() == null || !isValidIdCard(customer.getIdCard())) {
            throw new BusinessException("身份证号格式不正确");
        }
        if (customer.getPhone() == null || !isValidPhone(customer.getPhone())) {
            throw new BusinessException("手机号格式不正确");
        }
    }

    private boolean isValidIdCard(String idCard) {
        // 实现具体的身份证校验逻辑
        return idCard != null && idCard.matches("\\d{17}[\\dXx]");
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^1[3-9]\\d{9}$");
    }

    @Override
    public int addCustomer(Customer customer) {
        validateCustomer(customer);
        return customerMapper.insert(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("ID参数错误");
        }
        return customerMapper.deleteById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId() <= 0) {
            throw new BusinessException("ID参数错误");
        }
        validateCustomer(customer);
        return customerMapper.updateById(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("ID参数错误");
        }
        return customerMapper.selectById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerMapper.selectAll();
    }

    @Override
    public PageInfo<Customer> findPageCustomer(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(customerMapper.findPageCustomer(pageDTO));
    }
}