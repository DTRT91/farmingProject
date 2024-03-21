package com.RTF.farming_project.revenue.service;

import com.RTF.farming_project.revenue.dto.FarmCropAreaDto;
import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;

import java.util.List;

public interface RevenueService {


    int historySave(FarmHistorySaveDto history);
    List<FarmCropDto> getCropList();
    List<FarmCropAreaDto> getAreaList(int cropId);
    List<FarmHistorySaveDto> getCropAreaRevenue(FarmHistorySaveDto farmHistorySaveDto);


}
