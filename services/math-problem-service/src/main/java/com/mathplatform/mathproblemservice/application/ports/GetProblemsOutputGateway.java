package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.domain.Problem;
import java.util.List;

public interface GetProblemsOutputGateway {

    List<Problem> findAll();
}
