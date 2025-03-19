package com.ljq.backend.service.impl;

import com.ljq.backend.entity.Registration;
import com.ljq.backend.exception.BusinessException;
import com.ljq.backend.mapper.RegistrationMapper;
import com.ljq.backend.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationMapper registrationMapper;

    @Override
    public int addRegistration(Registration registration) {
        registration.setCheckinTime(LocalDateTime.now());
        return registrationMapper.insert(registration);
    }

    @Override
    public int deleteRegistration(String id) {
        return registrationMapper.deleteById(id);
    }

    @Override
    public int updateRegistration(Registration registration) {
        return registrationMapper.updateById(registration);
    }

    @Override
    public Registration getRegistrationById(String id) {
        return registrationMapper.selectById(id);
    }

    @Override
    public List<Registration> findAllRegistration() {
        return registrationMapper.selectAll();
    }

    @Override
    public Registration findByCustomerId(String id) {
        return registrationMapper.findByCustomerId(id);
    }
}