package com.RTF.farming_project.revenue.controller;

import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.dto.*;
import com.RTF.farming_project.revenue.service.RevenueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RevenueRestController {

    private final RevenueService revenueServiceImpl;
//    @GetMapping("/cropList")
//    public String getCropList (Model model){
//
//        return ResponseEntity.status(HttpStatus.OK).body(cropList);
//    }

    @GetMapping("/areaList/{areaName}")
    public ResponseEntity getAreaList(@PathVariable String areaName){
       List<FarmCropAreaDto> data = new ArrayList<>();
        data = revenueServiceImpl.getAreaList(areaName);

        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("/historySave")
    public ResponseEntity historySave (@RequestBody FarmHistorySaveDto history, HttpSession session) {
        int historySaveResult = revenueServiceImpl.historySave(history);
        return new ResponseEntity(historySaveResult, HttpStatus.OK);
    }
}
