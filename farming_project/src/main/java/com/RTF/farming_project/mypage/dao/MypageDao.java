package com.RTF.farming_project.mypage.dao;

import com.RTF.farming_project.mypage.dto.MypageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageDao {

    MypageDto updateUserInfo(MypageDto mypageDto);
}
