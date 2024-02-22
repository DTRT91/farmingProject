package com.RTF.farming_project.revenue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmHistorySaveDto {
    private int seq;
    private String userId;
    private String cropId;
    private int areaId;
    private double salesResult;
    private double preSalesResult;
    private int years;

}
