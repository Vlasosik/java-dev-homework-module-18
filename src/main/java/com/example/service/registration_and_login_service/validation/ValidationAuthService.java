package com.example.service.registration_and_login_service.validation;

import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidationAuthService {
    private final UserRepository userRepository;

    public boolean isUserLoginAndValid(String login) {
        return login.strip().length() <= 3;
    }

    public boolean isUserPasswordValid(String password) {
        return password.strip().length() <= 3;
    }
}
