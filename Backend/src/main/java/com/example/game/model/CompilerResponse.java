package com.example.game.model;

import lombok.Data;

@Data
public class CompilerResponse {
    private String output;
    private int statusCode;
    private int memory;
    private double cpuTime;
    private String error;
}
