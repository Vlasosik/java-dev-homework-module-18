package com.example.service.registration_and_login_service;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.registration_and_login_service.request.RegistrationRequest;
import com.example.service.registration_and_login_service.response.RegistrationResponse;
import com.example.service.registration_and_login_service.response.enum_error.ErrorMessage;
import com.example.service.registration_and_login_service.validation.ValidationAuthService;
import com.example.service.user_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthRegisterService {
    private final UserService userService;
    private final ValidationAuthService validationAuthService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public RegistrationResponse registerUser(RegistrationRequest request) {
        UserEntity existingUser = userService.findByUsername(request.getLogin());
        if (Objects.nonNull(existingUser)) {
            return RegistrationResponse.failed(ErrorMessage.USER_ALREADY_EXISTS);
        }
        if (validationAuthService.isUserLoginAndValid(request.getLogin())) {
            return RegistrationResponse.failed(ErrorMessage.INVALID_LOGIN);
        }
        if (validationAuthService.isUserPasswordValid(request.getPassword())) {
            return RegistrationResponse.failed(ErrorMessage.INVALID_PASSWORD);
        }
        saveUser(request);
        return RegistrationResponse.success();
    }

    private void saveUser(RegistrationRequest request) {
        UserEntity user = new UserEntity();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
//        String token = jwtUtil.generateToken(request.getLogin());
        // Ви можете зробити що завгодно з токеном, наприклад, повернути його у відповіді або зберегти для майбутнього використання
    }
}
