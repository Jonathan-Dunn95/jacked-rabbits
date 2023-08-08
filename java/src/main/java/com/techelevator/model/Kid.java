package com.techelevator.model;

public class Kid {
    private int kid_id;
    private String name;
    private int steps;

    public Kid(int kid_id, String name, int steps) {
        this.kid_id = kid_id;
        this.name = name;
        this.steps = steps;
    }

    public Kid() {
    }

    public Kid(String name, int steps) {

    }

    public int getKid_id() {
        return kid_id;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    public void setKid_id(int kid_id) {
        this.kid_id = kid_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
