package com.pasha.arena.app.transformer;

import com.pasha.arena.app.db.model.user.data.codewars.CodeWarsData;
import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserInfoResponse;
import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserSubmissionResponse;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public final class CodeWarsTransformer {

    public static void fillFromUserInfoResponse(CodeWarsData codeWarsData,
                                                CodeWarsUserInfoResponse infoResponse) {
        codeWarsData.setUsername(infoResponse.getUsername());
        codeWarsData.setFullname(infoResponse.getName());
        codeWarsData.setClan(infoResponse.getClan());
        codeWarsData.setHonor(infoResponse.getHonor());
        codeWarsData.setLeaderboardPosition(infoResponse.getLeaderboardPosition());
        codeWarsData.setSkills(infoResponse.getSkills());
        codeWarsData.setRank(infoResponse.getRanks().getOverall().getRank());
        codeWarsData.setRankName(infoResponse.getRanks().getOverall().getName());
        codeWarsData.setRankColor(infoResponse.getRanks().getOverall().getColor());
        codeWarsData.setRankScore(infoResponse.getRanks().getOverall().getScore());

    }


    public static void fillFromUserSubmissionsResponse(CodeWarsData codeWarsData,
                                                       List<CodeWarsUserSubmissionResponse.Submission> submissionsResponse) {
        codeWarsData.setSubmissionsCount(submissionsResponse.size());
        codeWarsData.setSubmissionsLastMonth(submissionsResponse.stream()
                .filter(sub -> sub.getCompletedAt().toEpochSecond(ZoneOffset.UTC) > (System.currentTimeMillis() / 1000) - 2629743)
                .map(CodeWarsTransformer::transformSubmission)
                .collect(Collectors.toList()));
    }


    private static CodeWarsData.CodeWarsSubmission transformSubmission(CodeWarsUserSubmissionResponse.Submission submissionResponse) {
        return CodeWarsData.CodeWarsSubmission.builder()
                .id(submissionResponse.getId())
                .name(submissionResponse.getName())
                .slug(submissionResponse.getSlug())
                .completedAt(submissionResponse.getCompletedAt().toEpochSecond(ZoneOffset.UTC))
                .completedLanguages(submissionResponse.getCompletedLanguages())
                .build();
    }

}
