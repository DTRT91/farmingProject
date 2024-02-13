package com.RTF.farming_project.revenue.service;

import com.RTF.farming_project.revenue.dao.RevenueDao;
import com.RTF.farming_project.revenue.dto.FarmCropAreaDto;
import com.RTF.farming_project.revenue.dto.FarmCropDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueDao revenueDao;

    @Override
    public int historySave(FarmHistorySaveDto history) { return revenueDao.historySave(history);
    }

    @Override
    public List<FarmCropDto> getCropList() {
        return revenueDao.getCropList();
    }

    @Override
    public List<FarmCropAreaDto> getAreaList(String areaName) { return revenueDao.getAreaList(areaName);
    }

    }



