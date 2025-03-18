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
    public int deleteRegistration(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("ID参数错误");
        }
        return registrationMapper.deleteById(id);
    }

    @Override
    public int updateRegistration(Registration registration) {
        if (registration.getId() == null || registration.getId() <= 0) {
            throw new BusinessException("ID参数错误");
        }
        return registrationMapper.updateById(registration);
    }

    @Override
    public Registration getRegistrationById(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException("ID参数错误");
        }
        return registrationMapper.selectById(id);
    }

    @Override
    public List<Registration> findAllRegistration() {
        return registrationMapper.selectAll();
    }
}