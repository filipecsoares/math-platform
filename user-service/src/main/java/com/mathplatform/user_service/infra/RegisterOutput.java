package com.mathplatform.user_service.infra;

import com.mathplatform.user_service.domain.User;

import java.util.UUID;

public record RegisterOutput(UUID id, String name, String email) {

    public static RegisterOutput fromUser(User user) {
        return new RegisterOutput(user.getId(), user.getName(), user.getEmail());
    }
}
