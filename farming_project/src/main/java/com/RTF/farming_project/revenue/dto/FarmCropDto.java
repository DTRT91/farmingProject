package com.RTF.farming_project.revenue.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
public class FarmCropDto {
    private int seq;
    private int cropId;
    private String cropName;
}



