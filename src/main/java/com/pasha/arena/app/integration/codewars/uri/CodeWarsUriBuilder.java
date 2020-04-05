package com.pasha.arena.app.integration.codewars.uri;

import com.pasha.arena.app.integration.codewars.properties.CodeWarsProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@AllArgsConstructor
public class CodeWarsUriBuilder {

    private final CodeWarsProperties codeWarsProperties;

    public URI getUserUri(String username) {
        return UriComponentsBuilder.fromUriString(codeWarsProperties.getUri() + codeWarsProperties.getPath() + codeWarsProperties.getMethod().getUserInfo() + username)
                .build()
                .encode()
                .toUri();
    }

    public URI getSubmissionsUri(String username) {
        return UriComponentsBuilder.fromUriString(codeWarsProperties.getUri() + codeWarsProperties.getPath() + "/" + username + codeWarsProperties.getMethod().getUserSubmissions())
                .queryParam("page", 0)
                .build()
                .encode()
                .toUri();
    }

}
