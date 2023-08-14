package com.techelevator.model;

public class Mascot {
    private int mascotId;
    private int kidId;
    private int shirt;

    private int shoes;
    private int hat;
    private int accessory;
    private int background;

    private int closetId;
private int mascotSelectionId;
    public Mascot(){

    }

    public Mascot(int mascotId, int kidId, int shirt, int shoes, int hat, int accessory, int background, int closetId, int mascotSelectionId) {
        this.mascotId = mascotId;
        this.kidId = kidId;
        this.shirt = shirt;
        this.shoes = shoes;
        this.hat = hat;
        this.accessory = accessory;
        this.background = background;
        this.closetId = closetId;
        this.mascotSelectionId = mascotSelectionId;
    }

//    public Mascot(Integer newId, int mascotId, int kidId, int shirt, int shoes, int hat, int accessory, int background, int closetId) {
//    }

    public Mascot(Integer newId, int mascotId, int kidId, int shirt, int shoes, int hat, int accessory, int background, int closetId, int mascotSelectionId) {
    }

    public int getMascotId() {
        return mascotId;
    }

    public void setMascotId(int mascotId) {
        this.mascotId = mascotId;
    }

    public int getKidId() {
        return kidId;
    }

    public int getMascotSelectionId() {
        return mascotSelectionId;
    }

    public void setMascotSelectionId(int mascotSelectionId) {
        this.mascotSelectionId = mascotSelectionId;
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

    @Override
    public String toString() {
        return "Mascot{" +
                "mascotId=" + mascotId +
                ", kidId=" + kidId +
                ", shirt=" + shirt +
                ", shoes=" + shoes +
                ", hat=" + hat +
                ", accessory=" + accessory +
                ", background=" + background +
                ", closetId=" + closetId +
                '}';
    }


}
