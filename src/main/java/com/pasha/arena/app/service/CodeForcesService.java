package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.db.model.user.data.codewars.CodeWarsData;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.integration.codeforces.dto.UserInfoResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserSubmissionResponse;
import com.pasha.arena.app.integration.codeforces.http.CodeForcesCommunicationService;
import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserInfoResponse;
import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserSubmissionResponse;
import com.pasha.arena.app.integration.codewars.http.CodeWarsCommunicationService;
import com.pasha.arena.app.transformer.CodeForcesTransformer;
import com.pasha.arena.app.transformer.CodeWarsTransformer;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeForcesService {

    private final CodeForcesCommunicationService codeforcesCommunicationService;
    private final CodeWarsCommunicationService codeWarsCommunicationService;
    private final UserRepository userRepository;

    public boolean existsByUsername(String username) {
        return codeforcesCommunicationService.existsByUsername(username);
    }
//Todo: refactor all this shit
    public UserDto getUserInfo(String username) {
        User user = userRepository.getByUsername(username);
        if (user == null) return null;

        String handle = user.getCodeForcesUsername();
        UserInfoResponse infoResponse = codeforcesCommunicationService.getUserInfo(handle);
        List<UserSubmissionResponse> submissionsResponse = codeforcesCommunicationService.getUserSubmissions(handle);

        CodeForcesData codeForcesData = new CodeForcesData();
        CodeForcesTransformer.fillFromUserInfoResponse(codeForcesData, infoResponse);
        CodeForcesTransformer.fillFromUserSubmissionsResponse(codeForcesData, submissionsResponse);
        user.setCodeForcesData(codeForcesData);

        //Fucking shit
        String codewarsUsername = user.getCodeWarsUsername();
        CodeWarsUserInfoResponse cwinfoResponse = codeWarsCommunicationService.getUserInfo(codewarsUsername);
        List<CodeWarsUserSubmissionResponse.Submission> cwsubmissionsResponse = codeWarsCommunicationService.getUserSubmissions(codewarsUsername);

        CodeWarsData codeWarsData = new CodeWarsData();
        CodeWarsTransformer.fillFromUserInfoResponse(codeWarsData, cwinfoResponse);
        CodeWarsTransformer.fillFromUserSubmissionsResponse(codeWarsData, cwsubmissionsResponse);
        user.setCodeWarsData(codeWarsData);

        return UserDtoTransformer.transform(user);
    }

}

