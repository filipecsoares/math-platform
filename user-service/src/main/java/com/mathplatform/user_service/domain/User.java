package com.mathplatform.user_service.domain;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(UUID id, String name, String email, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email must not be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("password must not be null or empty");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User newUser(String name, String email, String password) {
        return new User(UUID.randomUUID(), name, email, password);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
