package com.pasha.arena.app.web.model.auth;

import com.pasha.arena.app.constant.Role;
import com.pasha.arena.app.db.model.user.data.GlobalData;
import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.db.model.user.data.codewars.CodeWarsData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private Integer age;
    @NotNull
    private String group;
    @NotNull
    private Role role;

    private Long lastActiveAt;

    private GlobalData globalData;

    private String codeForcesUsername;
    private CodeForcesData codeForcesData;

    private String codeWarsUsername;
    private CodeWarsData codeWarsData;
}
