package com.RTF.farming_project.revenue.service;

import com.RTF.farming_project.revenue.dto.FarmCropAreaDto;
import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;

import java.util.List;
import java.util.Map;

public interface RevenueService {


    int historySave(FarmHistorySaveDto history);
    List<FarmCropDto> getCropList();
    List<FarmCropAreaDto> getAreaList(int cropId);

    List<FarmHistorySaveDto> getCropAreaRevenue(Map<String, Object> map);
}
