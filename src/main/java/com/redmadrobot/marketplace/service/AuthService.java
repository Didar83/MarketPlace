package com.redmadrobot.marketplace.service;

import com.redmadrobot.marketplace.dto.AuthenticationUserDto;
import com.redmadrobot.marketplace.dto.RegisterUserDto;
import com.redmadrobot.marketplace.model.UserEntity;
import com.redmadrobot.marketplace.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserEntityRepository userEntityRepository;

    public AuthService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public String register(RegisterUserDto registerUserDto) {
        UserEntity user = new UserEntity()
                .setEmail(registerUserDto.getEmail())
                .setPassword(registerUserDto.getPassword())
                .setRole(registerUserDto.getRole());
        UserEntity saved = userEntityRepository.save(user);
        return saved != null ? "Success" : "Failed";
    }

    public String authentication(AuthenticationUserDto authenticationUserDto) {
        UserEntity saved = userEntityRepository.findByEmail(authenticationUserDto.getEmail());
        return saved.getPassword().equals(authenticationUserDto.getPassword()) ? "Success" : "Failed";
    }
}
