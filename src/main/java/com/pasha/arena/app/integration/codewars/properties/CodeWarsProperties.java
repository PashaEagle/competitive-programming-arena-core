package com.pasha.arena.app.integration.codewars.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@ConfigurationProperties("codewars")
public class CodeWarsProperties {

    private String uri;
    private String path;
    private Method method;

    @Getter
    @Setter
    @Component
    @NoArgsConstructor
    @ConfigurationProperties("method")
    public static class Method {

        private String userInfo;
        private String userSubmissions;
    }

    private Timeout timeout;

    @Getter
    @Setter
    @Component
    @NoArgsConstructor
    @ConfigurationProperties(prefix = "timeout")
    public static class Timeout {

        private int connect;
        private int read;
    }
}
