package com.pasha.arena.app.service;

import com.pasha.arena.app.db.model.user.User;
import com.pasha.arena.app.db.repository.UserRepository;
import com.pasha.arena.app.integration.CodeforcesCommunicationService;
import com.pasha.arena.app.transformer.UserDtoTransformer;
import com.pasha.arena.app.web.model.auth.LoginRequestDto;
import com.pasha.arena.app.web.model.auth.RegisterRequestDto;
import com.pasha.arena.app.web.model.auth.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeforcesService {

    private final CodeforcesCommunicationService codeforcesCommunicationService;

    public User getCodeforcesData(){
        return null;
    }
}

