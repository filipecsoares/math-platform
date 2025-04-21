package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.application.domain.Problem;

public interface CreateProblemOutputGateway {

    Problem save(Problem problem);
}
