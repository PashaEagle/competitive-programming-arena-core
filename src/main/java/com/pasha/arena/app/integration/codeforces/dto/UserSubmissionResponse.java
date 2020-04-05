package com.pasha.arena.app.integration.codeforces.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSubmissionResponse {

    private Integer contestId;
    private Integer creationTimeSeconds;
    private Problem problem;
    private Author author;
    private String programmingLanguage;
    private Verdict verdict;
    private String testset;
    private Integer passedTestCount;
    private Integer timeConsumedMillis;
    private Integer memoryConsumedBytes;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Problem {

        private Integer contestId;
        private String problemsetName;
        private String index;
        private String name;
        private String type;
        private Double points;
        private Integer rating;
        private List<String> tags;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {

        private Integer contestId;
        private List<Member> members;
        private String participantType;
        private Integer teamId;
        private String teamName;
        private Boolean ghost;
        private Integer room;
        private Long startTimeSeconds;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Member {

            private String handle;
        }
    }

    public enum Verdict {
        FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED,
        MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED,
        CHALLENGED, SKIPPED, TESTING, REJECTED
    }

}
