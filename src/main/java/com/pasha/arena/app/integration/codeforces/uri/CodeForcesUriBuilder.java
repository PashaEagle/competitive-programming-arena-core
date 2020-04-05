package com.pasha.arena.app.integration.codeforces.uri;

import com.pasha.arena.app.integration.codeforces.properties.CodeForcesProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@AllArgsConstructor
public class CodeForcesUriBuilder {

    private final CodeForcesProperties codeforcesProperties;

    public URI getUserUri(String username) {
        return UriComponentsBuilder.fromUriString(codeforcesProperties.getUri())
                .pathSegment(codeforcesProperties.getPath(), codeforcesProperties.getMethod().getUserInfo())
                .queryParam("handles", username)
                .build()
                .encode()
                .toUri();
    }

    public URI getSubmissionsUri(String username) {
        return UriComponentsBuilder.fromUriString(codeforcesProperties.getUri())
                .pathSegment(codeforcesProperties.getPath(), codeforcesProperties.getMethod().getUserSubmissions())
                .queryParam("handle", username)
                .queryParam("from", 1)
                .queryParam("count", 30)
                .build()
                .encode()
                .toUri();
    }
}
