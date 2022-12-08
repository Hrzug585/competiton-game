package com.example.game.configuration;

import com.example.game.model.TaskInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@Configuration
public class AppConfig {
    private final Logger log = LogManager.getLogger(AppConfig.class);

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TaskInfo initializeTaskInfo() {
        ObjectMapper objectMapper = new ObjectMapper();
        TaskInfo taskInfo = null;
        try {
            taskInfo = objectMapper.readValue(new File("src/main/resources/static/taskInfo.json"), TaskInfo.class);
        } catch (IOException e) {
            log.error("Config file not found", e);
        }
        return taskInfo;
    }
}
