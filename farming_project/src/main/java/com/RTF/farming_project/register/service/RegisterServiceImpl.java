package com.RTF.farming_project.register.service;

import com.RTF.farming_project.register.dao.RegisterDao;
import com.RTF.farming_project.register.dto.RegisterDto;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterServiceImpl implements RegisterService{

    private final RegisterDao registerDao;

    public void register(RegisterDto registerDto){
        registerDao.register(registerDto);
    };
}
