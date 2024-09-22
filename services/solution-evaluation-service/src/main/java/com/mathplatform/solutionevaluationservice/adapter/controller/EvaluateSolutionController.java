package com.mathplatform.solutionevaluationservice.adapter.controller;

import com.mathplatform.solutionevaluationservice.application.dto.SolutionInput;
import com.mathplatform.solutionevaluationservice.application.dto.SolutionOutput;
import com.mathplatform.solutionevaluationservice.application.port.EvaluateSolutionInputGateway;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/solutions")
public class EvaluateSolutionController {

    private final EvaluateSolutionInputGateway evaluateSolutionInputGateway;

    public EvaluateSolutionController(EvaluateSolutionInputGateway evaluateSolutionInputGateway) {
        this.evaluateSolutionInputGateway = evaluateSolutionInputGateway;
    }

    @PostMapping
    public ResponseEntity<SolutionOutput> evaluate(@RequestBody @Valid SolutionInput input) {
        final var output = evaluateSolutionInputGateway.execute(input);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(output.id()).toUri();
        return ResponseEntity.created(location).body(output);
    }
}
