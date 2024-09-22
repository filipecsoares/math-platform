package com.mathplatform.solutionevaluationservice.application.port;

import com.mathplatform.solutionevaluationservice.domain.Solution;

public interface EvaluateSolutionOutputGateway {

    Solution save(final Solution solution);
}
