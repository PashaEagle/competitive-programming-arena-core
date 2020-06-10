package com.pasha.arena.app.integration.codewars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeWarsUserSubmissionResponse {

    private Integer totalPages;
    private Integer totalItems;
    @JsonProperty("data")
    private List<Submission> submissions;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Submission {

        private String id;
        private String name;
        private String slug;
        private List<String> completedLanguages;
        private LocalDateTime completedAt;
    }

}
