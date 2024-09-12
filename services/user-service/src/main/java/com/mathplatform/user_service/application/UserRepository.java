package com.mathplatform.user_service.application;

import com.mathplatform.user_service.domain.User;

public interface UserRepository {

    User save(User user);
    User findByEmail(String email);
}
