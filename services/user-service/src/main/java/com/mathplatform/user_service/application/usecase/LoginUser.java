package com.mathplatform.user_service.application.usecase;

import com.mathplatform.user_service.application.UserRepository;
import com.mathplatform.user_service.domain.Credential;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginUser {

    private final UserRepository userRepository;

    public LoginUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Credential execute(String email, String password) {
        var user = userRepository.findByEmail(email);
        var credential = new Credential("Bearer", "token", LocalDateTime.now().plusHours(1));
        return credential;
    }

}
