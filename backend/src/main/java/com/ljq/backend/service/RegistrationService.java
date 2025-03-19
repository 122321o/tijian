package com.ljq.backend.service;

import com.ljq.backend.entity.Registration;

import java.util.List;

public interface RegistrationService {
    int addRegistration(Registration registration);
    int deleteRegistration(String id);
    int updateRegistration(Registration registration);
    Registration getRegistrationById(String id);
    List<Registration> findAllRegistration();

    Registration findByCustomerId(String id);
}