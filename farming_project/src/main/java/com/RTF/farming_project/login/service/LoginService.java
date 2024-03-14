package com.RTF.farming_project.login.service;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.login.dto.LoginRequestDto;

public interface LoginService {

    LoginDto verifyUser(LoginRequestDto loginRequestDto);


}
