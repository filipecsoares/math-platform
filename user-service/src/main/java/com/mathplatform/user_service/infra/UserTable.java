package com.mathplatform.user_service.infra;

import com.mathplatform.user_service.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserTable {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public UserTable() {
    }

    public UserTable(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserTable fromDomain(User user) {
        return new UserTable(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
