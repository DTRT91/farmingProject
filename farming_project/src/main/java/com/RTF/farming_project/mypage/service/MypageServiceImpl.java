package com.RTF.farming_project.mypage.service;

import com.RTF.farming_project.mypage.dao.MypageDao;
import com.RTF.farming_project.mypage.dto.MypageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MypageDao mypageDao;

    public MypageDto updateUserInfo(MypageDto mypageDto){
        return mypageDao.updateUserInfo(mypageDto);
    }
}
