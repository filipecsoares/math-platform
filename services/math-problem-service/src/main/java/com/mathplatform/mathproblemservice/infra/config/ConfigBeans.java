package com.mathplatform.mathproblemservice.infra.config;

import com.mathplatform.mathproblemservice.application.ports.*;
import com.mathplatform.mathproblemservice.application.usecase.CreateProblemUseCase;
import com.mathplatform.mathproblemservice.application.usecase.GetAllProblemsUseCase;
import com.mathplatform.mathproblemservice.application.usecase.GetProblemByIdUseCase;
import com.mathplatform.mathproblemservice.infra.repository.GetProblemsRepositoryDatabase;
import com.mathplatform.mathproblemservice.infra.repository.ProblemRepositoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public CreateProblemInputGateway createProblemInputGateway() {
        return new CreateProblemUseCase(createProblemOutputGateway());
    }

    @Bean
    public CreateProblemOutputGateway createProblemOutputGateway() {
        return new ProblemRepositoryDatabase();
    }

    @Bean
    public GetAllProblemsInputGateway getAllProblemsInputGateway() {
        return new GetAllProblemsUseCase(getProblemsOutputGateway());
    }

    @Bean
    public GetProblemsOutputGateway getProblemsOutputGateway() {
        return new GetProblemsRepositoryDatabase();
    }

    @Bean
    public GetProblemByIdInputGateway getProblemByIdInputGateway() {
        return new GetProblemByIdUseCase(getProblemsOutputGateway());
    }
}
