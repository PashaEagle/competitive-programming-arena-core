package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.CodeForcesService;
import com.pasha.arena.app.service.CodeWarsService;
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
@RequestMapping("/api/codewars")
public class CodeWarsController {

    private final CodeWarsService codeWarsService;

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam String username) {
        log.info("Request to check codewars handle exists: {}", username);
        Boolean handleExists = codeWarsService.existsByUsername(username);
        log.info("Response on check codewars handle exists: {}", handleExists);
        return ResponseEntity.ok(handleExists);
    }

}
