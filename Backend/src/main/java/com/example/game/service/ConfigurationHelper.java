package com.example.game.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConfigurationHelper {
    @Value("${compiler.endpoint.url}")
    private String url;
    @Value("${compiler.endpoint.userAgent}")
    private String userAgent;
    @Value("${compiler.endpoint.clientID}")
    private String clientId;
    @Value("${compiler.endpoint.clientSecret}")
    private String clientSecret;
    @Value("${compiler.endpoint.language}")
    private String language;
    @Value("${compiler.endpoint.versionIndex}")
    private String versionIndex;
}
