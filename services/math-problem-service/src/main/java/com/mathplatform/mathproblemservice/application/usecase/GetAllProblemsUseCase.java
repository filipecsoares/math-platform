package com.mathplatform.mathproblemservice.application.usecase;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.GetAllProblemsInputGateway;
import com.mathplatform.mathproblemservice.application.ports.GetProblemsOutputGateway;
import java.util.List;

public class GetAllProblemsUseCase implements GetAllProblemsInputGateway {

    private final GetProblemsOutputGateway getProblemsOutputGateway;

    public GetAllProblemsUseCase(GetProblemsOutputGateway getProblemsOutputGateway) {
        this.getProblemsOutputGateway = getProblemsOutputGateway;
    }

    @Override
    public List<ProblemOutput> execute() {
        return getProblemsOutputGateway.findAll().stream().map(ProblemOutput::fromDomain).toList();
    }
}
