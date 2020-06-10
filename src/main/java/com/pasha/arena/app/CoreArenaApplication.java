package com.pasha.arena.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@EnableConfigurationProperties
public class CoreArenaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreArenaApplication.class, args);
        Instant time = Instant.parse("2019-11-15T17:47:09.146Z");
        System.out.println(time.getEpochSecond());
        System.out.println(new Date(time.getEpochSecond() * 1000));
    }

}
