package com.example.sample.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Component
public class OpenAPIConfiguration {

    private final ServerProperties serverProperties;

    public OpenAPIConfiguration(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Bean
    public OpenAPI openAPI() {
        String contextPath = serverProperties.getServlet().getContextPath();
        if (contextPath == null) {
            contextPath = "/";
        }
        return new OpenAPI()
                .addServersItem(new Server().url(contextPath));
    }
}
