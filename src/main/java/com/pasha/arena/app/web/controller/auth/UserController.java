package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.service.AuthService;
import com.pasha.arena.app.service.UserService;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> existsByUsername(@PathVariable String username) {

        log.info("Request to check user exists by username: {}", username);

        return ResponseEntity.ok(userService.existsByUsername(username));
    }
}
