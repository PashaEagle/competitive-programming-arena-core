package com.pasha.arena.app.transformer;

import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.integration.codeforces.dto.UserInfoResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserSubmissionResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class CodeForcesTransformer {

    public static void fillFromUserInfoResponse(CodeForcesData codeForcesData,
                                                UserInfoResponse infoResponse) {
        codeForcesData.setUsername(infoResponse.getHandle());
        codeForcesData.setRank(infoResponse.getRank());
        codeForcesData.setMaxRank(infoResponse.getMaxRank());
        codeForcesData.setRating(infoResponse.getRating());
        codeForcesData.setMaxRating(infoResponse.getMaxRating());
        codeForcesData.setLastOnlineAt(infoResponse.getLastOnlineTimeSeconds());
        codeForcesData.setRegisteredAt(infoResponse.getRegistrationTimeSeconds());

    }


    public static void fillFromUserSubmissionsResponse(CodeForcesData codeForcesData,
                                                       List<UserSubmissionResponse> submissionsResponse) {
        codeForcesData.setSubmissionsCount(submissionsResponse.size());
        codeForcesData.setLast30Submissions(submissionsResponse.stream()
                .map(CodeForcesTransformer::transformSubmission)
                .collect(Collectors.toList()));

    }


    private static CodeForcesData.CodeForcesSubmission transformSubmission(UserSubmissionResponse submissionResponse) {
        return CodeForcesData.CodeForcesSubmission.builder()
                .problemName(submissionResponse.getProblem().getName())
                .problemRating(submissionResponse.getProblem().getRating())
                .programmingLanguage(submissionResponse.getProgrammingLanguage())
                .passedTestsCount(submissionResponse.getPassedTestCount())
                .verdict(submissionResponse.getVerdict().name())
                .submittedAt(submissionResponse.getCreationTimeSeconds())
                .build();
    }

}
