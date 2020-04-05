package com.pasha.arena.app.integration.codewars.http;

import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserInfoResponse;
import com.pasha.arena.app.integration.codewars.dto.CodeWarsUserSubmissionResponse;
import com.pasha.arena.app.integration.codewars.uri.CodeWarsUriBuilder;
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
public class CodeWarsCommunicationService {

    private final CodeWarsUriBuilder codeWarsUriBuilder;
    private final RestTemplate codeWarsRestTemplate;

    public boolean existsByUsername(String username) {
        URI uri = codeWarsUriBuilder.getUserUri(username);
        ResponseEntity<CodeWarsUserInfoResponse> responseEntity = null;
        try {
            responseEntity = codeWarsRestTemplate.exchange(uri,
                    HttpMethod.GET, null, new ParameterizedTypeReference<CodeWarsUserInfoResponse>() {
                    });
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
        return !responseEntity.getStatusCode().isError();
    }

    public CodeWarsUserInfoResponse getUserInfo(String username) {
        URI uri = codeWarsUriBuilder.getUserUri(username);
        ResponseEntity<CodeWarsUserInfoResponse> responseEntity = null;
        try {
            responseEntity = codeWarsRestTemplate.exchange(uri,
                    HttpMethod.GET, null, new ParameterizedTypeReference<CodeWarsUserInfoResponse>() {
                    });
        } catch (HttpClientErrorException.BadRequest e) {
            return null;
        }
        return responseEntity.getBody();
    }

    public List<CodeWarsUserSubmissionResponse.Submission> getUserSubmissions(String username) {
        URI uri = codeWarsUriBuilder.getSubmissionsUri(username);
        ResponseEntity<CodeWarsUserSubmissionResponse> responseEntity = null;
        try {
            responseEntity = codeWarsRestTemplate.exchange(uri,
                    HttpMethod.GET, null, new ParameterizedTypeReference<CodeWarsUserSubmissionResponse>() {
                    });
        } catch (HttpClientErrorException.BadRequest e) {
            return null;
        }
        return responseEntity.getBody().getSubmissions();
    }

}
