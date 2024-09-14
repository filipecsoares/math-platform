package com.mathplatform.mathproblemservice.domain;

import java.util.UUID;

public class MathCategory {
    private UUID id;
    private String name;
    private String description;

    public MathCategory(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.description = description;
    }

    public MathCategory(String id) {
        this.id = UUID.fromString(id);
    }

    public String getId() {
        return this.id.toString();
    }
}
