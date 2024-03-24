package com.example.service.registration_and_login_service.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String login;
    private String password;
}
