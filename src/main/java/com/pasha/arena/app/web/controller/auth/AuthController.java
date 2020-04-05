package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.AuthService;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto) {
        log.info("Request to register: email: {}, username: {}, password: {}",
                registerRequestDto.getEmail(),
                registerRequestDto.getUsername(),
                registerRequestDto.getPassword());
        boolean success = authService.register(registerRequestDto);
        if (success) {
            log.info("Login successful");
            return ResponseEntity.ok(true);
        } else {
            log.info("Login error");
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        log.info("Request to login: username/email: {}, password: {}",
                loginRequestDto.getLoginString(),
                loginRequestDto.getPassword());
        UserDto userDto = authService.login(loginRequestDto);
        if (userDto != null) {
            log.info("Login successful");
            return ResponseEntity.ok(userDto);
        } else {
            log.info("Login error");
            return ResponseEntity.badRequest().build();
        }
    }
}
