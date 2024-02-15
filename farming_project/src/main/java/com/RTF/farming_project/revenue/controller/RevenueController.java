package com.RTF.farming_project.revenue.controller;

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

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j

public class RevenueController {

    private final RevenueService revenueServiceImpl;


    @GetMapping("/revenue")
    public String revenue(Model model){

        List<FarmCropDto> cropList = new ArrayList<>();
        FarmCropDto farmCropDto = new FarmCropDto();
        cropList = revenueServiceImpl.getCropList();

        model.addAttribute("cropId", farmCropDto.getCropId());
        model.addAttribute("cropList", cropList);
        return "/revenue/revenue";
    }

}
