package com.mathplatform.mathproblemservice.adapter.controller;

import com.mathplatform.mathproblemservice.application.dto.ProblemOutput;
import com.mathplatform.mathproblemservice.application.ports.GetAllProblemsInputGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/problems")
public class GetAllProblemsController {

     private final GetAllProblemsInputGateway getAllProblemsInputGateway;

     public GetAllProblemsController(GetAllProblemsInputGateway getAllProblemsInputGateway) {
         this.getAllProblemsInputGateway = getAllProblemsInputGateway;
     }

     @GetMapping
     public ResponseEntity<List<ProblemOutput>> getAll() {
         var output = getAllProblemsInputGateway.execute();
         return ResponseEntity.ok(output);
     }
}
