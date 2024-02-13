package com.RTF.farming_project.revenue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmHistorySaveDto {
    private int seq;
    private String userId;
    private String selectCrop;
    private String selectCropKor;
    private int salesResult;
}
