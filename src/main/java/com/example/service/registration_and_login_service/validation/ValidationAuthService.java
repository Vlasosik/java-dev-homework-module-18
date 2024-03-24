package com.example.service.registration_and_login_service.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidationAuthService {
    public boolean isUserLoginAndValid(String login) {
        return login.strip().length() <= 3;
    }

    public boolean isUserPasswordValid(String password) {
        return password.strip().length() <= 3;
    }
}
