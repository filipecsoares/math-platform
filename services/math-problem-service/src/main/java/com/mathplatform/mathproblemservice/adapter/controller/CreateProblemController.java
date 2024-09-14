package com.mathplatform.mathproblemservice.adapter.controller;

import com.mathplatform.mathproblemservice.application.dto.ProblemInput;
import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.CreateProblemInputGateway;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/problems")
public class CreateProblemController {

    private final CreateProblemInputGateway createProblemInputGateway;

    public CreateProblemController(CreateProblemInputGateway createProblemInputGateway) {
        this.createProblemInputGateway = createProblemInputGateway;
    }

    @PostMapping
    public ResponseEntity<ProblemOutput> create(@RequestBody @Valid ProblemInput input) {
        var output = createProblemInputGateway.execute(input);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("problemId").toUri();
        return ResponseEntity.created(location).body(output);
    }
}
