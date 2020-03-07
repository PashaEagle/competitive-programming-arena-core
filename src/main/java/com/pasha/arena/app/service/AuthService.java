package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.User;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public boolean register(RegisterRequestDto registerRequestDto) {

        boolean userExists = userRepository.existsByUsername(registerRequestDto.getUsername());
        if (userExists) {
            return false;
        }

        User user = UserDtoTransformer.transform(registerRequestDto);
        userRepository.save(user);
        return true;
    }

    public UserDto login(LoginRequestDto loginRequestDto) {

        User user = userRepository.getByUsernameAndPassword(loginRequestDto.getUsername(),
                loginRequestDto.getPassword());

        if (user == null) {
            return null;
        }

        return UserDtoTransformer.transform(user);
    }
}

