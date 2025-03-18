package com.ljq.backend.controller;

import com.ljq.backend.common.Result;
import com.ljq.backend.dto.page.CustomerPageDTO;
import com.ljq.backend.entity.Customer;
import com.ljq.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Result addCustomer(@RequestBody Customer customer) {
        return Result.success(customerService.addCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public Result deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return Result.success();
    }

    @PutMapping("update")
    public Result updateCustomer(@RequestBody Customer customer) {
        return Result.success(customerService.updateCustomer(customer));
    }

    @GetMapping("/{id}")
    public Result getCustomer(@PathVariable Integer id) {
        return Result.success(customerService.getCustomerById(id));
    }

    @GetMapping("/findAll")
    public Result findAllCustomer() {
        return Result.success(customerService.findAllCustomer());
    }

    @PostMapping("/findPage")
    public Result findPageCustomer(@RequestBody CustomerPageDTO customerPageDTO) {
        return Result.success(customerService.findPageCustomer(customerPageDTO));
    }
}