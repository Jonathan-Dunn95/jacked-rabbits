package com.techelevator.controller;

import com.techelevator.dao.ItemStoreDao;
import com.techelevator.dao.JdbcItemStoreDao;
import com.techelevator.dao.KidDao;
import com.techelevator.model.ItemStore;
import com.techelevator.model.Kid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class ItemStoreController {
    private ItemStoreDao itemStoreDao;

    public ItemStoreController(ItemStoreDao itemStoreDao) {
        this.itemStoreDao = itemStoreDao;
    }

    @RequestMapping(path = "/item_store/{itemId}", method = RequestMethod.GET)
    public ItemStore getItemById(@PathVariable int itemId) {
        return itemStoreDao.getItemByItemId(itemId);
    }

    @RequestMapping(path = "/item_store/{itemName}", method = RequestMethod.GET)
    public ItemStore getItemByName(@PathVariable String itemName) {
        return itemStoreDao.getItemByItemName(itemName);
    }

    @RequestMapping(path = "/users/{itemType}", method = RequestMethod.GET)
    public List<ItemStore> getAllItemsByType(@PathVariable String itemType){
        return itemStoreDao.getItemsByType(itemType);
    }
}

