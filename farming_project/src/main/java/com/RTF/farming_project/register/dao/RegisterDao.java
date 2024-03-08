package com.RTF.farming_project.register.dao;

import com.RTF.farming_project.register.dto.RegisterDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {

    void register(RegisterDto registerDTo);
}
