package com.RTF.farming_project.login.dao;

import com.RTF.farming_project.login.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    LoginDto verifyUser(LoginDto loginDto);
}
