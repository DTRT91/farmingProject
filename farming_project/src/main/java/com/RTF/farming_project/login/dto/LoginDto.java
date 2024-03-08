package com.RTF.farming_project.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private int seq;
    private int memberId;
    private String memberPassword;
    private String memberName;
}
