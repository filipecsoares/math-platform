package com.mathplatform.mathproblemservice.infra.repository;

import com.mathplatform.mathproblemservice.application.ports.GetProblemsOutputGateway;
import com.mathplatform.mathproblemservice.domain.Problem;
import com.mathplatform.mathproblemservice.infra.model.ProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class GetProblemsRepositoryDatabase implements GetProblemsOutputGateway {

    @Autowired
    private ProblemJpaRepository problemRepository;

    @Override
    public List<Problem> findAll() {
        return problemRepository.findAll().stream().map(ProblemModel::toDomain).toList();
    }
    @Override
    public Problem findById(final String id) {
        return problemRepository.findById(id).map(ProblemModel::toDomain).orElse(null);
    }
}
