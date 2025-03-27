package com.ljq.backend.controller;

import com.ljq.backend.result.Result;
import com.ljq.backend.entity.Registration;
import com.ljq.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/add")
    public Result addRegistration(@RequestBody Registration registration) {
        return Result.success(registrationService.addRegistration(registration));
    }

    @DeleteMapping("/{id}")
    public Result deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateRegistration(@RequestBody Registration registration) {
        return Result.success(registrationService.updateRegistration(registration));
    }

    @GetMapping("/{id}")
    public Result getRegistration(@PathVariable String id) {
        return Result.success(registrationService.getRegistrationById(id));
    }

    @GetMapping("/findAll")
    public Result findAllRegistration() {
        return Result.success(registrationService.findAllRegistration());
    }

    @GetMapping("/findByCustomerId/{id}")
    public Result findAllRegistration(@PathVariable String id) {
        return Result.success(registrationService.findByCustomerId(id));
    }
}