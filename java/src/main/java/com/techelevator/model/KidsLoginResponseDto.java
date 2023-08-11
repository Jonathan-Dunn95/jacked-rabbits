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
    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }
}
