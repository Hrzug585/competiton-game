package com.example.game.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompilerRequest {
    private String clientId;
    private String clientSecret;
    private String language;
    private int versionIndex;
    private String script;
}
