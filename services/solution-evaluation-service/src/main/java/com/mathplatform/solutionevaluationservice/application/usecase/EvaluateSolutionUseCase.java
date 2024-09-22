package com.mathplatform.solutionevaluationservice.application.usecase;

import com.mathplatform.solutionevaluationservice.application.dto.SolutionInput;
import com.mathplatform.solutionevaluationservice.application.dto.SolutionOutput;
import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionInputGateway;
import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionOutputGateway;
import com.mathplatform.solutionevaluationservice.domain.Solution;

public class EvaluateSolutionUseCase implements EvaluateSolutionInputGateway {

    private final EvaluateSolutionOutputGateway outputGateway;

    public EvaluateSolutionUseCase(EvaluateSolutionOutputGateway outputGateway) {
        this.outputGateway = outputGateway;
    }

    @Override
    public SolutionOutput execute(final SolutionInput input) {
        final var solution = Solution.create(input.solution(), input.problemId(), input.userId());
        return SolutionOutput.fromDomain(outputGateway.save(solution));
    }
}
