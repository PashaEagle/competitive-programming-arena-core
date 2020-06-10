package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.db.model.user.data.codeforces.CodeForcesData;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.integration.codeforces.dto.UserInfoResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserSubmissionResponse;
import com.pasha.arena.app.integration.codewars.http.CodeWarsCommunicationService;
import com.pasha.arena.app.transformer.CodeForcesTransformer;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeWarsService {

    private final CodeWarsCommunicationService codeWarsCommunicationService;

    public boolean existsByUsername(String username) {
        return codeWarsCommunicationService.existsByUsername(username);
    }

}

