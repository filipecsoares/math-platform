package com.mathplatform.user_service.infra.register;

import com.mathplatform.user_service.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterInput(@NotBlank String name, @NotBlank @Email String email, @NotBlank String password) {

    public User toUser() {
        return User.newUser(name, email, password);
    }
}
