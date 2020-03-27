package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final Clock utcClock;

    public boolean register(RegisterRequestDto registerRequestDto) {

        boolean userExists = userRepository.existsByUsername(registerRequestDto.getUsername()) || userRepository.existsByEmail(registerRequestDto.getEmail());
        if (userExists) {
            return false;
        }

        User user = UserDtoTransformer.transform(registerRequestDto);
        user.setLastActiveAt(System.currentTimeMillis());
        userRepository.save(user);
        return true;
    }

    public UserDto login(LoginRequestDto loginRequestDto) {

        User user = userRepository.getUserByLoginStringAndPassword(loginRequestDto.getLoginString(),
                loginRequestDto.getPassword());

        if (user == null) {
            return null;
        }

        return UserDtoTransformer.transform(user);
    }
}
