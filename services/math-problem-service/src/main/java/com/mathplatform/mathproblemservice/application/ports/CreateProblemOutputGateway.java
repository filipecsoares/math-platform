package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.domain.Problem;

public interface CreateProblemOutputGateway {

    Problem save(Problem problem);
}
