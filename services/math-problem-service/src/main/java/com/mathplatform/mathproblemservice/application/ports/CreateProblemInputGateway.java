package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.application.dto.ProblemInput;
import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;

public interface CreateProblemInputGateway {

    ProblemOutput execute(final ProblemInput problemInput);
}
