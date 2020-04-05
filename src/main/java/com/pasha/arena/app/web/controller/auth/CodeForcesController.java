package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.CodeForcesService;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/codeforces")
public class CodeForcesController {

    private final CodeForcesService codeforcesService;

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam String username) {
        log.info("Request to check codeforces handle exists: {}", username);
        Boolean handleExists = codeforcesService.existsByUsername(username);
        log.info("Response on check codeforces handle exists: {}", handleExists);
        return ResponseEntity.ok(handleExists);
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserInfo(@RequestParam String username) {
        log.info("Request to get codeforces user info, username: {}", username);
        UserDto userDto = codeforcesService.getUserInfo(username);
        log.info("Response on get codeforces user info, username: {}", username);
        return ResponseEntity.ok(userDto);
    }
}
