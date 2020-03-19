package com.pasha.arena.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ClockConfig {

    @Bean
    public Clock utcClock() {
        return Clock.systemUTC();
    }
}
