package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.application.domain.Problem;
import java.util.List;

public interface GetProblemsOutputGateway {

    List<Problem> findAll();
    Problem findById(final String id);
}
