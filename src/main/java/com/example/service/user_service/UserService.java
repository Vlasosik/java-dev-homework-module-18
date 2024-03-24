package com.example.service.user_service;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity findByUsername(String loginName) {
        Optional<UserEntity> user = userRepository.findByLogin(loginName);
        return user.orElse(null);
    }
}
