package com.RTF.farming_project.revenue.controller;

import com.RTF.farming_project.login.dto.LoginDto;
import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.service.RevenueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class RevenueController {

    private final RevenueService revenueServiceImpl;


    @GetMapping("/revenue")
    public String revenue(Model model, HttpSession session, HttpServletResponse response) throws IOException {

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
            List<FarmCropDto> cropList = new ArrayList<>();
            FarmCropDto farmCropDto = new FarmCropDto();
            cropList = revenueServiceImpl.getCropList();

            model.addAttribute("cropId", farmCropDto.getCropId());
            model.addAttribute("cropList", cropList);
            model.addAttribute("loginUser", loginUser);
            return "revenue/revenue";
        }
    }
}
