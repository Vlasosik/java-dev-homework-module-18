package com.example.service.registration_and_login_service;

import com.example.entity.UserEntity;
import com.example.security.jwt.JwtUtil;
import com.example.service.registration_and_login_service.request.LoginRequest;
import com.example.service.registration_and_login_service.response.LoginResponse;
import com.example.service.registration_and_login_service.response.enum_error.ErrorMessage;
import com.example.service.registration_and_login_service.validation.ValidationAuthService;
import com.example.service.user_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthLoginService {
    private final UserService userService;
    private final ValidationAuthService validationAuthService;
    private final JwtUtil jwtUtil;

    public LoginResponse loginUser(LoginRequest loginRequest) {
        UserEntity existUser = userService.findByUsername(loginRequest.getLogin());
        if (existUser == null) {
            return LoginResponse.failed(ErrorMessage.USER_DOES_NOT_EXIST);
        }
        if (validationAuthService.isUserLoginAndValid(loginRequest.getLogin())) {
            return LoginResponse.failed(ErrorMessage.INVALID_LOGIN);
        }
        if (validationAuthService.isUserPasswordValid(loginRequest.getPassword())) {
            return LoginResponse.failed(ErrorMessage.INVALID_PASSWORD);
        }
        if (existUser.getPassword().equals(loginRequest.getPassword())) {
            return LoginResponse.failed(ErrorMessage.INVALID_PASSWORD);
        }
        String authToken = jwtUtil.generateToken(loginRequest.getLogin());
        return LoginResponse.success(authToken);
    }
}
