package com.mathplatform.user_service.infra.login;

import com.mathplatform.user_service.domain.Credential;

public record LoginOutput(String type, String token) {

    public static LoginOutput fromCredential(Credential credential) {
        return new LoginOutput(credential.getType(), credential.getToken());
    }
}
