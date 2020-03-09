package com.pasha.arena.app.transformer;

import com.pasha.arena.app.constant.Role;
import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;

public final class UserDtoTransformer {

    public static User transform(RegisterRequestDto registerRequestDto){

        return User.builder()
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
                .username(user.getUsername())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .age(user.getAge())
                .group(user.getGroup())
                .role(user.getRole())
                .build();
    }
}
