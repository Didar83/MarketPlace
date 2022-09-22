package com.redmadrobot.marketplace.dto;

import com.redmadrobot.marketplace.model.Role;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.Email;

@Data
public class RegisterUserDto {

    @Email
    private String email;
    private String password;
    private Role role;

    public RegisterUserDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public RegisterUserDto(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = new Role("User");
    }
}
