package com.mathplatform.solutionevaluationservice.application.dto;

import jakarta.validation.constraints.NotBlank;

public record SolutionInput(@NotBlank String problemId, @NotBlank String solution, @NotBlank String userId) {

}
