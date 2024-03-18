package com.RTF.farming_project.mypage.service;

import com.RTF.farming_project.mypage.dao.MypageDao;
import com.RTF.farming_project.mypage.dto.MypageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface MypageService {
       MypageDto updateUserInfo(MypageDto mypageDto);
}
