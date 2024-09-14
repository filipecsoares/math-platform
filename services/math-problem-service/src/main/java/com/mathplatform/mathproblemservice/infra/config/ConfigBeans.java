package com.mathplatform.mathproblemservice.infra.config;

import com.mathplatform.mathproblemservice.application.ports.CreateProblemInputGateway;
import com.mathplatform.mathproblemservice.application.ports.CreateProblemOutputGateway;
import com.mathplatform.mathproblemservice.application.usecase.CreateProblemUseCase;
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
}
