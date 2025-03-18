package com.ljq.backend.service;

import com.ljq.backend.entity.Registration;

import java.util.List;

public interface RegistrationService {
    int addRegistration(Registration registration);
    int deleteRegistration(Integer id);
    int updateRegistration(Registration registration);
    Registration getRegistrationById(Integer id);
    List<Registration> findAllRegistration();
}