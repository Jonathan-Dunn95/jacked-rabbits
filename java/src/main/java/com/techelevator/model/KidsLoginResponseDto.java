package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KidsLoginResponseDto {

    private String token;
    private Kid kid;

    public KidsLoginResponseDto(String token, Kid kid) {
        this.token = token;
        this.kid = kid;
    }

    @JsonProperty("token")
    String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("user")
    public Kid getUser() {
        return kid;
    }

    public void setUser(Kid kid) {
        this.kid = kid;
    }
}
