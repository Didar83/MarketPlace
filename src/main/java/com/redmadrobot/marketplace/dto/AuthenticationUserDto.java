package com.redmadrobot.marketplace.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class AuthenticationUserDto {
    @Email
    private String email;
    private String password;
}
