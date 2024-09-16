package com.mathplatform.mathproblemservice.domain;

import java.util.UUID;

public class Problem {

    private UUID id;
    private String description;
    private String answer;
    private MathCategory category;
    private DifficultyEnum difficulty;

    public Problem(String id, String description, String answer, String categoryId, String difficulty) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("Answer cannot be null or empty");
        }
        if (categoryId != null) {
            this.category = new MathCategory(categoryId);
        }
        this.description = description;
        this.answer = answer;
        this.difficulty = DifficultyEnum.fromString(difficulty);
        this.id = UUID.fromString(id);
    }

    public static Problem newProblem(String description, String answer, String categoryId, String difficulty) {
        return new Problem(UUID.randomUUID().toString(), description, answer, categoryId, difficulty);
    }

    public String getId() {
        return this.id != null ? this.id.toString() : null;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getCategoryId() {
        return this.category != null ? this.category.getId() : null;
    }

    public String getDifficult() {
        return this.difficulty != null ? this.difficulty.toString() : null;
    }
}
