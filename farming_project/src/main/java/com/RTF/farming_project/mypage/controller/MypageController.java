package com.RTF.farming_project.mypage.controller;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.mypage.dto.MypageDto;
import com.RTF.farming_project.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageServiceImpl;
    @GetMapping("/mypage")
    public String mypage (Model model, HttpSession session) {
        LoginDto loginUser = (LoginDto) session.getAttribute("loginUser");

        model.addAttribute("loginUser", loginUser);

        return "mypage/mypage"; }

    @PutMapping("/update")
    public String updateUserInfo(@RequestBody MypageDto mypageDto){
        int updateUserInfoResult = 0;
        mypageServiceImpl.updateUserInfo(mypageDto);

        return "redirect:/mypage/mypage";
    }
}
