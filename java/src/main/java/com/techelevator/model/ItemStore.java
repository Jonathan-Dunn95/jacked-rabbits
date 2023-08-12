package com.techelevator.model;

public class ItemStore {

    private int itemId;

    private String imgURL;

    public ItemStore() {}

    public ItemStore(int itemId, String imgURL) {
        this.itemId = itemId;
        this.imgURL = imgURL;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
