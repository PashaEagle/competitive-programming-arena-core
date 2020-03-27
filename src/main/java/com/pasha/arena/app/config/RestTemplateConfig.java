package com.pasha.arena.app.config;

import com.pasha.arena.app.integration.codeforces.properties.CodeforcesProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@AllArgsConstructor
public class RestTemplateConfig {

    private final CodeforcesProperties codeforcesProperties;

    @Bean
    RestTemplate codeforcesRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(codeforcesProperties.getTimeout().getConnect()))
                .setReadTimeout(Duration.ofMillis(codeforcesProperties.getTimeout().getRead()))
                .build();
    }
}
