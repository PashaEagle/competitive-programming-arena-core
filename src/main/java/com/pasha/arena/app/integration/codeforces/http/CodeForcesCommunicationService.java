package com.pasha.arena.app.integration.codeforces.http;

import com.pasha.arena.app.integration.codeforces.dto.CodeForcesResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserInfoResponse;
import com.pasha.arena.app.integration.codeforces.dto.UserSubmissionResponse;
import com.pasha.arena.app.integration.codeforces.uri.CodeForcesUriBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CodeForcesCommunicationService {

    private final CodeForcesUriBuilder codeforcesUriBuilder;
    private final RestTemplate codeForcesRestTemplate;

    public boolean existsByUsername(String username) {
        URI uri = codeforcesUriBuilder.getUserUri(username);
        ResponseEntity<CodeForcesResponse<List<UserInfoResponse>>> responseEntity = null;
        try {
            responseEntity = codeForcesRestTemplate.exchange(uri,
                HttpMethod.GET, null, new ParameterizedTypeReference<CodeForcesResponse<List<UserInfoResponse>>>() {
                });
        } catch (HttpClientErrorException.BadRequest e){
            return false;
        }
        return !responseEntity.getStatusCode().isError();
    }

    public UserInfoResponse getUserInfo(String username){
        URI uri = codeforcesUriBuilder.getUserUri(username);
        ResponseEntity<CodeForcesResponse<List<UserInfoResponse>>> responseEntity = null;
        try {
            responseEntity = codeForcesRestTemplate.exchange(uri,
                    HttpMethod.GET, null, new ParameterizedTypeReference<CodeForcesResponse<List<UserInfoResponse>>>() {
                    });
        } catch (HttpClientErrorException.BadRequest e){
            return null;
        }
        return responseEntity.getBody().getResult().get(0);
    }

    public List<UserSubmissionResponse> getUserSubmissions(String username){
        URI uri = codeforcesUriBuilder.getSubmissionsUri(username);
        ResponseEntity<CodeForcesResponse<List<UserSubmissionResponse>>> responseEntity = null;
        try {
            responseEntity = codeForcesRestTemplate.exchange(uri,
                    HttpMethod.GET, null, new ParameterizedTypeReference<CodeForcesResponse<List<UserSubmissionResponse>>>() {
                    });
        } catch (HttpClientErrorException.BadRequest e){
            return null;
        }
        return responseEntity.getBody().getResult();
    }

}
