package com.mathplatform.user_service.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateUser() {
        User user = User.newUser("name", "email@email.com", "password");
        assertEquals("name", user.getName());
        assertEquals("email@email.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getId());
    }

    @Test
    void shouldNotCreateUserWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> User.newUser("", "email@email.com", "password"));
    }

    @Test
    void shouldNotCreateUserWithEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> User.newUser("name", "", "password"));
    }

    @Test
    void shouldNotCreateUserWithEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> User.newUser("name", "email", ""));
    }
}