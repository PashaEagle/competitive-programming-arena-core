package com.pasha.arena.app.integration.codewars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeWarsUserInfoResponse {

    private String username;
    private String name;
    private Integer honor;
    private String clan;
    private Long leaderboardPosition;
    private List<String> skills;
    private Rank ranks;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rank {

        private Overall overall;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Overall {

            private Integer rank;
            private String name;
            private String color;
            private Integer score;
        }
    }

    private CodeChallenge codeChallenges;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CodeChallenge {

        private Integer totalAuthored;
        private Integer totalCompleted;
    }
}
