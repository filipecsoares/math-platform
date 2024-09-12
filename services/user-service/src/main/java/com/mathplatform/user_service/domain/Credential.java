package com.mathplatform.user_service.domain;

import java.time.LocalDateTime;

public class Credential {
    private String type;
    private String token;
    private LocalDateTime expiration;

    public Credential(String type, String token, LocalDateTime expiration) {
        this.type = type;
        this.token = token;
        this.expiration = expiration;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }
}
