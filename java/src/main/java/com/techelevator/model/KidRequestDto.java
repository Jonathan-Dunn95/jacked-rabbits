package com.techelevator.model;

public class KidRequestDto {

    private String username;
    private int parentId;
    private int carrots;
    private String passwordHash;

    private int playTime;

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCarrots() {
        return carrots;
    }

    public void setCarrots(int carrots) {
        this.carrots = carrots;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
