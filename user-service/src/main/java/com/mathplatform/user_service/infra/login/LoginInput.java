package com.mathplatform.user_service.infra.login;

import jakarta.validation.constraints.NotBlank;

public record LoginInput(@NotBlank String email, @NotBlank String password) {
}
