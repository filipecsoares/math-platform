package com.mathplatform.user_service.infra;

import com.mathplatform.user_service.application.RegisterUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final RegisterUser registerUser;

    public UserController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterOutput> register(@Valid @RequestBody RegisterInput input) {
        var output = RegisterOutput.fromUser(registerUser.execute(input.toUser()));
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
