package com.logicoy.expense_tracker.dto;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
