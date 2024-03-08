package com.RTF.farming_project.register.controller;

import com.RTF.farming_project.register.dao.RegisterDao;
import com.RTF.farming_project.register.dto.RegisterDto;
import com.RTF.farming_project.register.service.RegisterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterRestController {

    private final RegisterService registerServiceImpl;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto registerDto){
        registerServiceImpl.register(registerDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
