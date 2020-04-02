package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto getUser(String email) {
        return UserDtoTransformer.transform(userRepository.getByEmail(email));
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDtoTransformer::transform)
                .collect(Collectors.toList());
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void update(UserDto userDto) {
        User user = userRepository.getByEmail(userDto.getEmail());
        userRepository.save(UserDtoTransformer.updateUserFromDto(user, userDto));
    }
}

