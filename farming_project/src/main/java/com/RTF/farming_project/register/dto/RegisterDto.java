package com.RTF.farming_project.register.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private int seq;
    private String userId;
    private String password;
    private String userName;
    private String phone;
    private String email;
    private String birthday;
}
