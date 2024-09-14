package com.mathplatform.mathproblemservice.domain;

public enum DifficultyEnum {
    EASY,
    MEDIUM,
    HARD;

    public static DifficultyEnum fromString(String difficulty) {
        if (difficulty == null) {
            return null;
        }
        return DifficultyEnum.valueOf(difficulty.toUpperCase());
    }
}
