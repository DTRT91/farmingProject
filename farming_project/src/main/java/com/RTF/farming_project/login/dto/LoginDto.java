package com.RTF.farming_project.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private int seq;
    private String username;
    private String userid;
    private String password;
    private String email;
    private String phone;
    private String age;
    private String birthday;
}
