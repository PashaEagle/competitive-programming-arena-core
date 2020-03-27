package com.pasha.arena.app.service;

import com.pasha.arena.app.integration.codeforces.http.CodeforcesCommunicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeforcesService {

    private final CodeforcesCommunicationService codeforcesCommunicationService;

    public boolean existsByUsername(String username) {

        return codeforcesCommunicationService.existsByUsername(username);
    }
}

