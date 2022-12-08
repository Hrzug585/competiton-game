package com.example.game.service;

import com.example.game.model.CompilerRequest;
import com.example.game.model.CompilerResponse;
import com.example.game.model.Solution;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompilerService {
    private ConfigurationHelper configurationHelper;
    private RestTemplate restTemplate;

    @Autowired
    public CompilerService(ConfigurationHelper configurationHelper, RestTemplate restTemplate) {
        this.configurationHelper = configurationHelper;
        this.restTemplate = restTemplate;
    }

    public CompilerResponse sendSolution(Solution solution) {

        JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, solution.getScript());
        javaClass.addMethod()
                .setPublic()
                .setName("main")
                .setStatic(true)
                .setReturnTypeVoid()
                .setBody("System.out.println(isEven(1));")
                .addParameter("java.lang.String[]", "args");

        CompilerRequest compilerRequest = CompilerRequest.builder()
                .clientId(configurationHelper.getClientId())
                .clientSecret(configurationHelper.getClientSecret())
                .language(configurationHelper.getLanguage())
                .versionIndex(0)
                .script(javaClass.toString())
                .build();

        ResponseEntity<CompilerResponse> responseEntity = restTemplate.exchange(configurationHelper.getUrl(), HttpMethod.POST, new HttpEntity<>(compilerRequest), CompilerResponse.class);
        return responseEntity.getBody();
    }
}
