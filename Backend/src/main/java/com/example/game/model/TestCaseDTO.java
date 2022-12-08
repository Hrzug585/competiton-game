package com.example.game.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TestCaseDTO {
    private int id;
    private String script;
    private String input;
    private String output;
}
