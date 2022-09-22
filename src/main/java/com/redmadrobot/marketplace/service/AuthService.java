package com.redmadrobot.marketplace.service;

import com.redmadrobot.marketplace.dto.AuthenticationUserDto;
import com.redmadrobot.marketplace.dto.RegisterUserDto;
import com.redmadrobot.marketplace.model.UserEntity;
import com.redmadrobot.marketplace.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
        log.info("f161b66e AuthService.register method. UserEntity: " + saved);
        return saved != null ? "Success" : "Failed";
    }

    public String authentication(AuthenticationUserDto authenticationUserDto) {
        UserEntity saved = userEntityRepository.findByEmail(authenticationUserDto.getEmail());
        boolean isPasswordCorrect = saved.getPassword().equals(authenticationUserDto.getPassword());
        log.info("e4ef2abd AuthService.authentication method. Is password correct: " + isPasswordCorrect);
        return isPasswordCorrect ? "Success" : "Failed";
    }
}
