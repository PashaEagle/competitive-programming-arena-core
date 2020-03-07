package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.AuthService;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
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

        log.info("Request to register: username: {}, password: {}", registerRequestDto.getUsername(), registerRequestDto.getPassword());
        boolean success = authService.register(registerRequestDto);
        if (success)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {

        log.info("Request to login: username: {}, password: {}", loginRequestDto.getUsername(), loginRequestDto.getPassword());
        UserDto userDto = authService.login(loginRequestDto);
        if (userDto != null)
            return ResponseEntity.ok(userDto);
        else
            return ResponseEntity.badRequest().build();
    }
}

