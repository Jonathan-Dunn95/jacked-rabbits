package com.techelevator.model;

public class Kid {
    private int kidId;
    private int parentId;
    private String username;
    private int carrots;
    private int passwordHash;

    public Kid(int kidId, int parentId, String username, int carrots, int passwordHash) {
        this.kidId = kidId;
        this.parentId = parentId;
        this.username = username;
        this.carrots = carrots;
        this.passwordHash = passwordHash;
    }

    public Kid() {
    }

    public Kid(int parentId, String username, int carrots) {
        this.parentId = parentId;
        this.username = username;
        this.carrots = carrots;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getKidId() {
        return kidId;
    }

    public String getUsername() {
        return username;
    }

    public int getCarrots() {
        return carrots;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCarrots(int carrots) {
        this.carrots = carrots;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
