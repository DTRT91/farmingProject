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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/areaList/{selectedCropId}")
    public ResponseEntity getAreaList(@PathVariable("selectedCropId") Integer cropId){
       List<FarmCropAreaDto> data = new ArrayList<>();
        data = revenueServiceImpl.getAreaList(cropId);

        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping
    public ResponseEntity getCropAreaRevenue(@PathVariable("params") Map<String,Object> params ,String cropName, String areaName){
        Map<String,Object> map = new HashMap<String, Object>();
        if(cropName == null)
            cropName ="";
            map.put("cropName", params.get("cropName"));
        if(areaName == null)
            areaName = "";
        map.put("areaName", params.get("areaName"));
        List<FarmHistorySaveDto> data = new ArrayList<>();
        data = revenueServiceImpl.getCropAreaRevenue(map);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("/historySave")
    public ResponseEntity historySave (@RequestBody FarmHistorySaveDto history, HttpSession session) {
        int historySaveResult = revenueServiceImpl.historySave(history);
        return new ResponseEntity(historySaveResult, HttpStatus.OK);
    }


}
