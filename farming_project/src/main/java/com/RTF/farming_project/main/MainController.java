package com.RTF.farming_project.main;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final LoginService loginServiceImpl;

    @GetMapping("/")
    public String defaultRequest() { return "redirect:/main"; }

    @GetMapping("/main")
    public String main(Model model, @SessionAttribute(name="loginUser", required = false) LoginDto loginUser) {
        if(loginUser != null) {
            log.info("세션 확인" + loginUser.getUserid());
            model.addAttribute("loginUser", loginUser);
        }
        return "main";}
}
