package com.RTF.farming_project.revenue.dao;

import com.RTF.farming_project.revenue.dto.FarmCropAreaDto;
import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RevenueDao {

    int historySave(FarmHistorySaveDto history);
    List<FarmCropDto> getCropList();

    List<FarmCropAreaDto> getAreaList(int cropId);

    List<FarmHistorySaveDto> getCropAreaRevenue(FarmHistorySaveDto farmHistorySaveDto);

}
