package com.example.sample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = true)
public class AppProperties {
    private String name = "app";
}
