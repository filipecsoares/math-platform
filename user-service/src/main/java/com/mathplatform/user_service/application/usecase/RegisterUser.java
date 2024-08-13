package com.mathplatform.user_service.application.usecase;

import com.mathplatform.user_service.application.UserRepository;
import com.mathplatform.user_service.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {

    private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
