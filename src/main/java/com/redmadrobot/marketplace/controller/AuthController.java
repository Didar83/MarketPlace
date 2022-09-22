package com.redmadrobot.marketplace.controller;

import com.redmadrobot.marketplace.dto.AuthenticationUserDto;
import com.redmadrobot.marketplace.dto.RegisterUserDto;
import com.redmadrobot.marketplace.exception.AuthenticationException;
import com.redmadrobot.marketplace.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AuthController {
//    Регистрация и аутентификация пользователя в личном кабинете:
//    - пользователь при регистрации должен указать роль, email и пароль;
//    - аутентификацию реализовать через вход по email и паролю.

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "Register new User")
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.ok(authService.register(registerUserDto));
    }

    @ApiOperation(value = "Authentication an User")
    @PostMapping("/authentication")
    public ResponseEntity authentication(@RequestBody AuthenticationUserDto authenticationUserDto) throws AuthenticationException {
        String authMe = authService.authentication(authenticationUserDto);
        if (authMe.equalsIgnoreCase("Success")) {
            return ResponseEntity.ok("Success");
        } else {
            throw new AuthenticationException("Wrong pass");
        }
    }

}
