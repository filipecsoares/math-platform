package com.mathplatform.user_service.domain;

public class Email {
    private String value;

    public Email(String value) {
        if (!isValidEmail(value)) {
            throw new IllegalArgumentException("Invalid email: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
}
