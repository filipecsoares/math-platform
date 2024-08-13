package com.mathplatform.user_service.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateAValidEmail() {
        Email email = new Email("a@a.com");
        assertEquals("a@a.com", email.getValue());
    }

    @Test
    void shouldNotCreateAnEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    void shouldNotCreateAnInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Email("a@a"));
    }

    @Test
    void shouldNotCreateAnInvalidEmail2() {
        assertThrows(IllegalArgumentException.class, () -> new Email("a"));
    }
}