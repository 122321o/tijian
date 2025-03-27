package com.ljq.backend.controller;

import com.ljq.backend.result.Result;
import com.ljq.backend.dto.CustomerPageDTO;
import com.ljq.backend.entity.Customer;
import com.ljq.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("add")
    public Result addCustomer(@RequestBody Customer customer) {
        return Result.success(customerService.addCustomer(customer));
    }

    @GetMapping("getCustomerId")
    public Result getCustomerId() {
        return Result.success(customerService.generateCustomerId());
    }

    @PostMapping("delete")
    public Result deleteCustomer(@RequestBody Map<String, String> request) {
        String id = request.get("id");
        customerService.deleteCustomer(id);
        return Result.success();
    }

    @PostMapping("update")
    public Result updateCustomer(@RequestBody Customer customer) {
        return Result.success(customerService.updateCustomer(customer));
    }

    @GetMapping("/{id}")
    public Result getCustomer(@PathVariable String id) {
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