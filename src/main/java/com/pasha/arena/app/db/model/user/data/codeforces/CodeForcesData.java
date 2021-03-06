package com.pasha.arena.app.db.model.user.data.codeforces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeForcesData {

    private String username;
    private String rank;
    private String maxRank;
    private Integer rating;
    private Integer maxRating;
    private Long lastOnlineAt;
    private Long registeredAt;
    private Integer submissionsCount;
    List<CodeForcesSubmission> submissionsLastMonth;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CodeForcesSubmission {

        Long submittedAt;
        String problemName;
        Integer problemRating;
        String verdict;
        Integer passedTestsCount;
        String programmingLanguage;
    }

}
