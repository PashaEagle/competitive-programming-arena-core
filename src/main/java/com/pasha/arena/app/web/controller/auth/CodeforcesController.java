package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.CodeforcesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/codeforces")
public class CodeforcesController {

    private final CodeforcesService codeforcesService;

    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> existsByUsername(@PathVariable String username) {

        log.info("Request to check codeforces handle exists: {}", username);

        return ResponseEntity.ok(codeforcesService.existsByUsername(username));
    }
}
