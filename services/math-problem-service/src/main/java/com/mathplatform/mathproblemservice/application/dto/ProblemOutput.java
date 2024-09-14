package com.mathplatform.mathproblemservice.application.dto;

import com.mathplatform.mathproblemservice.domain.Problem;

public record ProblemOutput(String id, String description, String answer, String category, String difficulty) {

    public static ProblemOutput fromDomain(Problem problem) {
        return new ProblemOutput(
                problem.getId(),
                problem.getDescription(),
                problem.getAnswer(),
                problem.getCategoryId(),
                problem.getDifficult());
    }
}
