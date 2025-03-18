package com.ljq.backend.mapper;

import com.ljq.backend.entity.Registration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegistrationMapper {
    int insert(Registration registration);
    int deleteById(Integer id);
    int updateById(Registration registration);
    Registration selectById(Integer id);
    List<Registration> selectAll();
}