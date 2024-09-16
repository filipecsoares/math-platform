package com.mathplatform.mathproblemservice.application.ports;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import java.util.List;

public interface GetAllProblemsInputGateway {

    List<ProblemOutput> execute();
}
