package com.mathplatform.solutionevaluationservice.infra.config;

import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionInputGateway;
import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionOutputGateway;
import com.mathplatform.solutionevaluationservice.application.usecase.EvaluateSolutionUseCase;
import com.mathplatform.solutionevaluationservice.infra.repository.SolutionRepositoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public EvaluateSolutionInputGateway evaluateSolutionInputGateway() {
        return new EvaluateSolutionUseCase(evaluateSolutionOutputGateway());
    }

    @Bean
    public EvaluateSolutionOutputGateway evaluateSolutionOutputGateway() {
        return new SolutionRepositoryDatabase();
    }
}
