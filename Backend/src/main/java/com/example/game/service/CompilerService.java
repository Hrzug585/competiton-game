package com.example.game.service;

import com.example.game.model.CompilerRequest;
import com.example.game.model.CompilerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompilerService {
    private final ConfigurationHelper configurationHelper;
    private final RestTemplate restTemplate;

    @Autowired
    public CompilerService(ConfigurationHelper configurationHelper, RestTemplate restTemplate) {
        this.configurationHelper = configurationHelper;
        this.restTemplate = restTemplate;
    }

    public CompilerResponse sendSolution(String input) {
        CompilerRequest compilerRequest = CompilerRequest.builder()
                .clientId(configurationHelper.getClientId())
                .clientSecret(configurationHelper.getClientSecret())
                .language(configurationHelper.getLanguage())
                .versionIndex(0)
                .script(input)
                .build();

        ResponseEntity<CompilerResponse> responseEntity = restTemplate.exchange(configurationHelper.getUrl(), HttpMethod.POST, new HttpEntity<>(compilerRequest), CompilerResponse.class);
        return responseEntity.getBody();
    }
}
