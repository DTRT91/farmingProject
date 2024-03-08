package com.RTF.farming_project.login.controller;

//import com.RTF.farming_project.common.util.ShaUtil;
import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {
    private static LoginService loginServiceImpl;

    @GetMapping
    public String login(){ return "/login/login"; }

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity verifyUser (@RequestBody LoginDto loginDto, Model model, HttpSession session) {
        LoginDto loginUser = loginServiceImpl.verifyUser(loginDto);

        if(loginUser != null){
            session.setAttribute("loginUser", loginUser);
        }
        return new ResponseEntity(loginUser, HttpStatus.OK);
    }
}
