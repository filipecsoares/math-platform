package com.mathplatform.mathproblemservice.infra.repository;

import com.mathplatform.mathproblemservice.application.ports.CreateProblemOutputGateway;
import com.mathplatform.mathproblemservice.domain.Problem;
import com.mathplatform.mathproblemservice.infra.model.ProblemModel;
import org.springframework.beans.factory.annotation.Autowired;

public class ProblemRepositoryDatabase implements CreateProblemOutputGateway {

    @Autowired
    private ProblemJpaRepository problemRepository;

    @Override
    public Problem save(Problem problem) {
        var problemModel = problemRepository.save(ProblemModel.fromDomain(problem));
        return problemModel.toDomain();
    }
}
