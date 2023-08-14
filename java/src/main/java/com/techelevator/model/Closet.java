package com.techelevator.model;

public class Closet {
    private int mascotId;
    private int itemId;

    public Closet(int mascotId, int itemId) {
        this.mascotId = mascotId;
        this.itemId = itemId;
    }

    public Closet() {
    }


    public int getMascotId() {
        return mascotId;
    }

    public void setMascotId(int mascotId) {
        this.mascotId = mascotId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
