package com.techelevator.dao;

import com.techelevator.model.ItemStore;

import java.util.List;

public interface ItemStoreDao {

    ItemStore getItemByItemId(int itemId);

    ItemStore getItemByItemName(String itemName);

    List<ItemStore> getItemsByType(String itemType);


}