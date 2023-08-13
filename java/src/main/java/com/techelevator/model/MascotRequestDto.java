package com.techelevator.model;

public class MascotRequestDto {
    private int kidId;
    private int shirt;

    private int shoes;
    private int hat;
    private int accessory;
    private int background;

    private int closetId;

    public MascotRequestDto(int kidId, int shirt, int shoes, int hat, int accessory, int background, int closetId) {
        this.kidId = kidId;
        this.shirt = shirt;
        this.shoes = shoes;
        this.hat = hat;
        this.accessory = accessory;
        this.background = background;
        this.closetId = closetId;
    }

    public int getKidId() {
        return kidId;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
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

    public int getClosetId() {
        return closetId;
    }

    public void setClosetId(int closetId) {
        this.closetId = closetId;
    }
}
