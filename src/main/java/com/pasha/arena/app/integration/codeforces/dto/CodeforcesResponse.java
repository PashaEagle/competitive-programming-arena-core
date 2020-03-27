package com.pasha.arena.app.integration.codeforces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeforcesResponse<T> {

    public enum ResponseStatus {OK, FAILED}

    @NotNull
    private ResponseStatus status;

    private T result;
}
