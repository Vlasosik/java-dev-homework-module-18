package com.example.controller.auth;

import com.example.service.registration_and_login_service.AuthLoginService;
import com.example.service.registration_and_login_service.AuthRegisterService;
import com.example.service.registration_and_login_service.request.LoginRequest;
import com.example.service.registration_and_login_service.request.RegistrationRequest;
import com.example.service.registration_and_login_service.response.LoginResponse;
import com.example.service.registration_and_login_service.response.RegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes/authentications")
@RequiredArgsConstructor
public class AuthController {
    private final AuthRegisterService authRegisterService;
    private final AuthLoginService authLoginService;

    @PostMapping("/registers")
    public RegistrationResponse register(@RequestBody RegistrationRequest request) {
        return authRegisterService.registerUser(request);
    }

    @PostMapping("/logins")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authLoginService.loginUser(request);
    }
}
