package com.mathplatform.user_service.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateUser() {
        User user = User.newUser("name", "email", "password");
        assertEquals("name", user.getName());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getId());
    }

    @Test
    void shouldNotCreateUserWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> User.newUser("", "email", "password"));
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