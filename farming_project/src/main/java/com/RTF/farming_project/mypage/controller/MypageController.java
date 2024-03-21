package com.RTF.farming_project.mypage.controller;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.mypage.dto.MypageDto;
import com.RTF.farming_project.mypage.service.MypageService;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageServiceImpl;

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session, HttpServletResponse response) throws IOException {

        LoginDto loginUser = (LoginDto) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script> alert('로그인이 필요합니다.');");
            out.println("location.href='/main'; </script>");
            out.close();
            return "main";
        } else {
            model.addAttribute("loginUser", loginUser);
            return "mypage/mypage";
        }
    }

    @PutMapping("/update")
    public String updateUserInfo(@RequestBody MypageDto mypageDto){
        int updateUserInfoResult = 0;
        mypageServiceImpl.updateUserInfo(mypageDto);

        return "redirect:/mypage/mypage";
    }

    @GetMapping("/historyLoad/{userId}")
    public ResponseEntity historyLoad (@PathVariable String userId, HttpSession session){
        List<FarmHistorySaveDto> data = new ArrayList<>();
        data = mypageServiceImpl.historyLoad(userId);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
