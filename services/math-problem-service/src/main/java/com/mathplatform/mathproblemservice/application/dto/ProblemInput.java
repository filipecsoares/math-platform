package com.mathplatform.mathproblemservice.application.dto;

import jakarta.validation.constraints.NotBlank;

public record ProblemInput(@NotBlank String description, @NotBlank String answer, String categoryId, String difficulty) {

}
