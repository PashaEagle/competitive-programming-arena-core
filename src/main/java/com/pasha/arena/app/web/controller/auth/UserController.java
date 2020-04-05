package com.pasha.arena.app.web.controller.auth;

import com.pasha.arena.app.service.UserService;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam String email) {
        log.info("Request to get info about user with email {} received..", email);
        UserDto userDto = userService.getUser(email);
        log.info("User successfully found");
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        log.info("Request to get all users received..");
        List<UserDto> users = userService.getAll();
        log.info("Returning all the users from db, amount: {}", users.size());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam String username) {
        log.info("Request to check user exists by username: {}", username);
        Boolean userExists = userService.existsByUsername(username);
        log.info("User {} exists = {}", username, userExists);
        return ResponseEntity.ok(userExists);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDto userDto) {
        log.info("Request to update user info for user with email: {}", userDto);
        userService.update(userDto);
        log.info("Successfully updated");
        return ResponseEntity.ok().build();
    }

}
