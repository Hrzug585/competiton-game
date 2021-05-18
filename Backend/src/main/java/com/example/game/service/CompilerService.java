package com.example.game.service;

import com.example.game.model.CompilerRequest;
import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
public class CompilerService {
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

    public CompilerResponse sendSolution(Solution solution) {
        CompilerRequest compilerRequest = new CompilerRequest(clientId, clientSecret, language, versionIndex, solution.getScript());
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String input = "";

        try {
            input = objectMapper.writeValueAsString(compilerRequest);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(new ArrayList<MediaType>(Arrays.asList(MediaType.ALL)));
        httpHeaders.set("User-Agent", userAgent);

        HttpEntity<String> httpEntity = new HttpEntity<>(input, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        String responseString = responseEntity.getBody();
        CompilerResponse compilerResponse = null;
        try {
            compilerResponse = objectMapper.readValue(responseString, CompilerResponse.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        log.debug(responseString);

        return compilerResponse;
    }
}
