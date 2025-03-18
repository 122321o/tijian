package com.ljq.backend.controller;

import com.ljq.backend.common.Result;
import com.ljq.backend.entity.Registration;
import com.ljq.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public Result deleteRegistration(@PathVariable Integer id) {
        registrationService.deleteRegistration(id);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateRegistration(@RequestBody Registration registration) {
        return Result.success(registrationService.updateRegistration(registration));
    }

    @GetMapping("/{id}")
    public Result getRegistration(@PathVariable Integer id) {
        return Result.success(registrationService.getRegistrationById(id));
    }

    @GetMapping("/findAll")
    public Result findAllRegistration() {
        return Result.success(registrationService.findAllRegistration());
    }
}