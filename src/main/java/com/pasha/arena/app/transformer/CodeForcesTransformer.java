package com.pasha.arena.app.transformer;

import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.integration.codeforces.dto.UserInfoResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserSubmissionResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public final class CodeForcesTransformer {

    public static CodeForcesData fillFromUserInfoResponse(CodeForcesData codeForcesData,
                                                          UserInfoResponse infoResponse) {
        codeForcesData.setUsername(infoResponse.getHandle());
        codeForcesData.setRank(infoResponse.getRank());
        codeForcesData.setMaxRank(infoResponse.getMaxRank());
        codeForcesData.setRating(infoResponse.getRating());
        codeForcesData.setMaxRating(infoResponse.getMaxRating());
        codeForcesData.setLastOnlineAt(LocalDateTime.ofInstant(Instant.ofEpochSecond(infoResponse.getLastOnlineTimeSeconds()),
                TimeZone.getDefault().toZoneId()));
        codeForcesData.setRegisteredAt(LocalDateTime.ofInstant(Instant.ofEpochSecond(infoResponse.getRegistrationTimeSeconds()),
                TimeZone.getDefault().toZoneId()));

        return codeForcesData;
    }


    public static CodeForcesData fillFromUserSubmissionsResponse(CodeForcesData codeForcesData,
                                                                 List<UserSubmissionResponse> submissionsResponse) {
        codeForcesData.setSubmissionsCount(submissionsResponse.size());
        codeForcesData.setLast30Submissions(submissionsResponse.stream()
                .map(CodeForcesTransformer::transformSubmission)
                .collect(Collectors.toList()));

        return codeForcesData;
    }


    private static CodeForcesData.CodeForcesSubmission transformSubmission(UserSubmissionResponse submissionResponse) {
        return CodeForcesData.CodeForcesSubmission.builder()
                .problemName(submissionResponse.getProblem().getName())
                .problemRating(submissionResponse.getProblem().getRating())
                .programmingLanguage(submissionResponse.getProgrammingLanguage())
                .passedTestsCount(submissionResponse.getPassedTestCount())
                .verdict(submissionResponse.getVerdict().name())
                .submittedAt(LocalDateTime.ofInstant(Instant.ofEpochSecond(submissionResponse.getCreationTimeSeconds()),
                        TimeZone.getDefault().toZoneId()))
                .build();
    }

}
