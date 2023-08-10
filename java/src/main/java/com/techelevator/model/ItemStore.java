package com.techelevator.model;

public class ItemStore {
    private int itemId;
    private String itemType;
    private String itemName;

    public ItemStore(int itemId, String itemType, String itemName) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.itemName = itemName;
    }


    public ItemStore() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
