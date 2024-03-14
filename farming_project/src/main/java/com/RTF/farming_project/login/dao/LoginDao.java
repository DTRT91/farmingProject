package com.RTF.farming_project.login.dao;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.login.dto.LoginRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    LoginDto verifyUser(LoginRequestDto loginRequestDto);
}
