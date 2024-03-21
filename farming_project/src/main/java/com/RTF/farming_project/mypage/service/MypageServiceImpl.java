package com.RTF.farming_project.mypage.service;

import com.RTF.farming_project.mypage.dao.MypageDao;
import com.RTF.farming_project.mypage.dto.MypageDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDao mypageDao;

    public MypageDto updateUserInfo(MypageDto mypageDto){
        return mypageDao.updateUserInfo(mypageDto);
    }

    public List<FarmHistorySaveDto> historyLoad(String userId) {
        return mypageDao.historyLoad(userId);
    }
}
