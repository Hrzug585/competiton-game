package com.example.game.model;

import lombok.Data;

@Data
public class CompilerResponse {
    private String output;
    private String statusCode;
    private String memory;
    private String cpuTime;
    private String error;
}
