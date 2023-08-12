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
    public ItemStore getItemByItemId(@PathVariable int itemId) {
        return itemStoreDao.getItemByItemId(itemId);
    }


}

