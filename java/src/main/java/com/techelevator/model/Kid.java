package com.techelevator.model;

import java.util.HashSet;
import java.util.Set;

public class Kid {
    private int kidId;
    private int parentId;
    private String username;
    private int carrots;
    private String passwordHash;
    private int playTime;

    private Set<Authority> authorities = new HashSet<>();

    public Kid(int kidId, int parentId, String username, int carrots, String passwordHash, int playTime, String authorities) {
        this.kidId = kidId;
        this.parentId = parentId;
        this.username = username;
        this.carrots = carrots;
        this.passwordHash = passwordHash;
        this.playTime = playTime;
        if (authorities != null) this.setAuthorities(authorities);
    }



    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public Kid() {
    }

    public Kid(int parentId, String username, int carrots) {
        this.parentId = parentId;
        this.username = username;
        this.carrots = carrots;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthorities(String authorities) {
        String[] roles = authorities.split(",");
        for (String role : roles) {
            String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
            this.authorities.add(new Authority(authority));
        }
    }
}
