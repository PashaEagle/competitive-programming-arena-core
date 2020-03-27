package com.pasha.arena.app.web.model.auth;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class LoginRequestDto {

    @NotNull
    private String loginString;
    @NotNull
    private String password;
}
