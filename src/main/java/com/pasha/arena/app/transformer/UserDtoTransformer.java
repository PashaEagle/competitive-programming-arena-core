package com.pasha.arena.app.transformer;

import com.pasha.arena.app.constant.Role;
import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;

public final class UserDtoTransformer {

    public static User transform(RegisterRequestDto registerRequestDto){

        return User.builder()
                .email(registerRequestDto.getEmail())
                .username(registerRequestDto.getUsername())
                .fullName(registerRequestDto.getFullName())
                .password(registerRequestDto.getPassword())
                .age(registerRequestDto.getAge())
                .group(registerRequestDto.getGroup())
                .role(Role.ROLE_USER)
                .build();
    }

    public static UserDto transform(User user){

        return UserDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .age(user.getAge())
                .group(user.getGroup())
                .role(user.getRole())
                .codeForcesUsername(user.getCodeForcesUsername())
                .codeWarsUsername(user.getCodeWarsUsername())
                .build();
    }

    public static User updateUserFromDto(User user, UserDto userDto){

        user.setUsername(userDto.getUsername());
        user.setFullName(userDto.getFullName());
        user.setAge(userDto.getAge());
        user.setGroup(userDto.getGroup());
        user.setPassword(userDto.getPassword());
        user.setCodeForcesUsername(userDto.getCodeForcesUsername());
        user.setCodeWarsUsername(userDto.getCodeWarsUsername());
        user.setLastActiveAt(System.currentTimeMillis());

        return user;
    }
}
