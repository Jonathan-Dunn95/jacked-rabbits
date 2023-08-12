package com.techelevator.model;

public class Closet {
    private int closet_id;
    private int mascot_id;
    private int shirt;
    private int shoes;
    private int hat;
    private int accessory;
    private int background;

    public Closet(int closet_id, int mascot_id, int shirt, int shoes, int hat, int accessory, int background) {
        this.closet_id = closet_id;
        this.mascot_id = mascot_id;
        this.shirt = shirt;
        this.shoes = shoes;
        this.hat = hat;
        this.accessory = accessory;
        this.background = background;
    }

    public Closet() {

    }

    public int getCloset_id() {
        return closet_id;
    }

    public void setCloset_id(int closet_id) {
        this.closet_id = closet_id;
    }

    public int getMascot_id() {
        return mascot_id;
    }

    public void setMascot_id(int mascot_id) {
        this.mascot_id = mascot_id;
    }

    public int getShirt() {
        return shirt;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public int getShoes() {
        return shoes;
    }

    public void setShoes(int shoes) {
        this.shoes = shoes;
    }

    public int getHat() {
        return hat;
    }

    public void setHat(int hat) {
        this.hat = hat;
    }

    public int getAccessory() {
        return accessory;
    }

    public void setAccessory(int accessory) {
        this.accessory = accessory;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}

  


