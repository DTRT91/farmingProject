package com.RTF.farming_project.mypage.service;

import com.RTF.farming_project.mypage.dao.MypageDao;
import com.RTF.farming_project.mypage.dto.MypageDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MypageService {
       MypageDto updateUserInfo(MypageDto mypageDto);

       List<FarmHistorySaveDto> historyLoad(String userId);
}
