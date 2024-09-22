package com.mathplatform.solutionevaluationservice.application.port;

import com.mathplatform.solutionevaluationservice.application.dto.SolutionInput;
import com.mathplatform.solutionevaluationservice.application.dto.SolutionOutput;

public interface EvaluateSolutionInputGateway {

    SolutionOutput execute(final SolutionInput input);
}
