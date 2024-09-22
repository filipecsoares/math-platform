package com.mathplatform.solutionevaluationservice.infra.repository;

import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionOutputGateway;
import com.mathplatform.solutionevaluationservice.domain.Solution;
import com.mathplatform.solutionevaluationservice.infra.model.SolutionModel;
import org.springframework.beans.factory.annotation.Autowired;

public class SolutionRepositoryDatabase implements EvaluateSolutionOutputGateway {

    @Autowired
    private SolutionJPARepository solutionJPARepository;

    @Override
    public Solution save(Solution solution) {
        return solutionJPARepository.save(SolutionModel.fromDomain(solution)).toDomain();
    }
}
