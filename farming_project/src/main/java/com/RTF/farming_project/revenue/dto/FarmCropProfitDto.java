package com.RTF.farming_project.revenue.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class FarmCropProfitDto {
    private int year;
    private int revenue;
    private int interept;
    private int Pcost;
    private int Dcost;
    private int temp;
    private int rain;
    private int sun;
    private int insolation;
    private int Hprice;
    private int gdp;
    private int area;
    private int yield;
}
