package com.mathplatform.user_service.infra;

import com.mathplatform.user_service.application.usecase.LoginUser;
import com.mathplatform.user_service.application.usecase.RegisterUser;
import com.mathplatform.user_service.infra.login.LoginInput;
import com.mathplatform.user_service.infra.login.LoginOutput;
import com.mathplatform.user_service.infra.register.RegisterInput;
import com.mathplatform.user_service.infra.register.RegisterOutput;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {

    private final RegisterUser registerUser;
    private final LoginUser loginUser;

    public AuthController(RegisterUser registerUser, LoginUser loginUser) {
        this.registerUser = registerUser;
        this.loginUser = loginUser;
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

    @PostMapping("/login")
    public ResponseEntity<LoginOutput> login(@Valid @RequestBody LoginInput input) {
        var credential = loginUser.execute(input.email(), input.password());
        return ResponseEntity.ok(LoginOutput.fromCredential(credential));
    }
}
