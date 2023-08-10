package com.techelevator.model;

public class ActivityRequestDto {
    private int kidsId;
    private int steps;
    private int minutes;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getKidsId() {
        return kidsId;
    }

    public void setKidsId(int kidsId) {
        this.kidsId = kidsId;
    }
}
