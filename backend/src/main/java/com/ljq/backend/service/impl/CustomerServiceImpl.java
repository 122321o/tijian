package com.ljq.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljq.backend.dto.CustomerPageDTO;
import com.ljq.backend.dto.PageDTO;
import com.ljq.backend.entity.Customer;
import com.ljq.backend.exception.BusinessException;
import com.ljq.backend.mapper.CustomerMapper;
import com.ljq.backend.mapper.RegistrationMapper;
import com.ljq.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RegistrationMapper registrationMapper;


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
        if (customer.getGender() == null || (customer.getGender() != 0 && customer.getGender() != 1 && customer.getGender() != 2)) {
            throw new BusinessException("客户性别格式不正确");
        }
        if (customer.getAge() == null || customer.getAge() < 0 || customer.getAge() > 120) {
            throw new BusinessException("客户年龄应在0到120岁之间");
        }
        if (customer.getBirthDate() == null || customer.getBirthDate().isBefore(LocalDate.of(1900, 1, 1))) {
            throw new BusinessException("客户出生日期应在1900年至今之间");
        }
        if (customer.getMarriage() == null || (customer.getMarriage() != 0 && customer.getMarriage() != 1)) {
            throw new BusinessException("客户婚姻状态格式不正确");
        }
    }

    private boolean isValidIdCard(String idCard) {
        return idCard != null && idCard.matches("\\d{17}[\\dXx]");
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^1[3-9]\\d{9}$");
    }

    private void validateGender(Integer gender) {
        if (gender == null || (gender != 0 && gender != 1 && gender != 2)) {
            throw new BusinessException("客户性别格式不正确");
        }
    }

    @Transactional
    public String generateCustomerId() {
        // 获取当前日期前缀，格式为 yyyyMMdd
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 查询数据库中当天最大的客户 ID
        String maxId = customerMapper.getMaxCustomerIdByDate(datePrefix);

        int nextSequence = 1; // 默认从 0001 开始
        if (maxId != null && maxId.startsWith(datePrefix)) {
            // 如果存在当天的记录，提取最后 4 位并加 1
            String sequencePart = maxId.substring(8); // 提取最后 4 位
            nextSequence = Integer.parseInt(sequencePart) + 1;
        }

        // 生成新的客户 ID，格式为 yyyyMMdd + 4 位序列号
        return datePrefix + String.format("%04d", nextSequence);
    }

    @Override
    public int addCustomer(Customer customer) {
        validateCustomer(customer);
        return customerMapper.insert(customer);
    }

    @Override
    public int deleteCustomer(String id) {
        registrationMapper.deleteByCustomerId(id);
        return customerMapper.deleteById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        validateCustomer(customer);
        return customerMapper.updateById(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerMapper.selectById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerMapper.selectAll();
    }

    @Override
    public PageInfo<CustomerPageDTO> findPageCustomer(PageDTO pageDTO) {
        CustomerPageDTO customerPageDTO = (CustomerPageDTO) pageDTO;
        LocalDateTime startDate = customerPageDTO.getStartDate();
        LocalDateTime endDate = customerPageDTO.getEndDate();

        // 如果 startDate 不为空，设置为当天的 00:00:00
        if (startDate != null) {
            startDate = startDate.toLocalDate().atStartOfDay(); // 转换为当天的 00:00:00
            customerPageDTO.setStartDate(startDate);
        }

        // 如果 endDate 不为空，设置为当天的 23:59:59
        if (endDate != null) {
            endDate = endDate.toLocalDate().atTime(23, 59, 59); // 转换为当天的 23:59:59
            customerPageDTO.setEndDate(endDate);
        }

        PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
        return new PageInfo<>(customerMapper.findPageCustomer(pageDTO));
    }
}