package com.example.game.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCaseReponse {
    private String input;
    private String output;
    private String expectedOutput;
    private int statusCode;
    private int memory;
    private double cpuTime;
    private String error;
}
