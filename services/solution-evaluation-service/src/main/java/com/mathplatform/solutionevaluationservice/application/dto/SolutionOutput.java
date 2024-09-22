package com.mathplatform.solutionevaluationservice.application.dto;

import com.mathplatform.solutionevaluationservice.domain.Solution;

public record SolutionOutput(String id, String solution, String problem, String user) {

    public static SolutionOutput fromDomain(final Solution solution) {
        return new SolutionOutput(solution.getId(), solution.getSolution(), solution.getProblemId(), solution.getUserId());
    }
}
