package com.mathplatform.user_service.application;

import com.mathplatform.user_service.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {

    public User execute(User user) {
        // save user
        return user;
    }
}
