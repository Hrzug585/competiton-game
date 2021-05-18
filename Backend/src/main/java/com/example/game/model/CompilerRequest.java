package com.example.game.model;

public class CompilerRequest {
    private String clientId;
    private String clientSecret;
    private String language;
    private String versionIndex;
    private String script;

    public CompilerRequest(String clientId, String clientSecret, String language, String versionIndex, String script) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.language = language;
        this.versionIndex = versionIndex;
        this.script = script;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVersionIndex() {
        return versionIndex;
    }

    public void setVersionIndex(String versionIndex) {
        this.versionIndex = versionIndex;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
