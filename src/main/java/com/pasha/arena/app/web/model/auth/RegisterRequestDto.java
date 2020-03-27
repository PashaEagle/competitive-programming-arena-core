package com.pasha.arena.app.web.model.auth;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterRequestDto {

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
}
