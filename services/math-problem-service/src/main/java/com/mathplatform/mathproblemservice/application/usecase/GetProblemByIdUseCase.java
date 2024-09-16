package com.mathplatform.mathproblemservice.application.usecase;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.GetProblemByIdInputGateway;
import com.mathplatform.mathproblemservice.application.ports.GetProblemsOutputGateway;

public class GetProblemByIdUseCase implements GetProblemByIdInputGateway {

    private final GetProblemsOutputGateway getProblemsOutputGateway;

    public GetProblemByIdUseCase(GetProblemsOutputGateway getProblemsOutputGateway) {
        this.getProblemsOutputGateway = getProblemsOutputGateway;
    }

    @Override
    public ProblemOutput execute(String id) {
        return ProblemOutput.fromDomain(getProblemsOutputGateway.findById(id));
    }
}
