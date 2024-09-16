package com.mathplatform.mathproblemservice.application.usecase;

import com.mathplatform.mathproblemservice.application.dto.ProblemInput;
import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.CreateProblemInputGateway;
import com.mathplatform.mathproblemservice.application.ports.CreateProblemOutputGateway;
import com.mathplatform.mathproblemservice.domain.Problem;

public class CreateProblemUseCase implements CreateProblemInputGateway {

    private final CreateProblemOutputGateway createProblemOutputGateway;

    public CreateProblemUseCase(CreateProblemOutputGateway createProblemOutputGateway) {
        this.createProblemOutputGateway = createProblemOutputGateway;
    }

    @Override
    public ProblemOutput execute(ProblemInput problemInput) {
        var problem = Problem.newProblem(problemInput.description(), problemInput.answer(), problemInput.categoryId(), problemInput.difficulty());
        var savedProblem = createProblemOutputGateway.save(problem);
        return ProblemOutput.fromDomain(savedProblem);
    }
}
