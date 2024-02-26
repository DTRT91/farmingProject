package com.RTF.farming_project.login.service;

import com.RTF.farming_project.login.dao.LoginDao;
import com.RTF.farming_project.login.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginDao loginDao;
    @Override
    public LoginDto verifyUser(LoginDto loginDto) { return loginDao.verifyUser(loginDto);
    }
}
