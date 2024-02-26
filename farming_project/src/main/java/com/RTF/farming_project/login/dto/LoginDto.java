package com.RTF.farming_project.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private int seq;
    private int userId;
    private String userName;
    private String phone;
    private String email;
}
