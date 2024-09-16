package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;

public interface GetProblemByIdInputGateway {

    ProblemOutput execute(final String id);
}
