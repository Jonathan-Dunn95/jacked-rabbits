package com.techelevator.model;

public class Closet {
    private int item_id;
    private int mascot_id;

    public Closet(int item_id, int mascot_id){
        this.item_id = item_id;
        this.mascot_id = mascot_id;
    }
    public Closet(){

    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getMascot_id() {
        return mascot_id;
    }

    public void setMascot_id(int mascot_id) {
        this.mascot_id = mascot_id;
    }
}
  


