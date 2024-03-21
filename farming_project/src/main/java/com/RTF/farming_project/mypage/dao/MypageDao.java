package com.RTF.farming_project.mypage.dao;

import com.RTF.farming_project.mypage.dto.MypageDto;
import com.RTF.farming_project.revenue.dto.FarmHistorySaveDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageDao {

    MypageDto updateUserInfo(MypageDto mypageDto);

    List<FarmHistorySaveDto> historyLoad(String userId);
}
