package com.techelevator.model;

import org.springframework.stereotype.Service;


public class Activity {

    private int kidId;
    private int steps;
    private int minutes;

    public Activity(int kidId, int steps, int minutes) {
        this.kidId = kidId;
        this.steps = steps;
        this.minutes = minutes;
    }

    public Activity() {}

    public int getKidId() {
        return kidId;
    }
    //implement constructor without parameters
    public Activity(){

    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

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
}
