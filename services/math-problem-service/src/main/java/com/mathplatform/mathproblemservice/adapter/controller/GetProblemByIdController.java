package com.mathplatform.mathproblemservice.adapter.controller;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.GetProblemByIdInputGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/problems")
public class GetProblemByIdController {

     private final GetProblemByIdInputGateway getProblemByIdInputGateway;

     public GetProblemByIdController(GetProblemByIdInputGateway getProblemByIdInputGateway) {
         this.getProblemByIdInputGateway = getProblemByIdInputGateway;
     }

     @GetMapping("/{id}")
     public ResponseEntity<ProblemOutput> getById(@PathVariable String id) {
         var output = getProblemByIdInputGateway.execute(id);
         return ResponseEntity.ok(output);
     }
}
