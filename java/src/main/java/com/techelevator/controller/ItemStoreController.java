package com.techelevator.controller;

import com.techelevator.dao.ItemStoreDao;
import com.techelevator.dao.JdbcItemStoreDao;
import com.techelevator.dao.KidDao;
import com.techelevator.model.Closet;
import com.techelevator.model.ItemStore;
import com.techelevator.model.Kid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ItemStoreController {

    private ItemStoreDao itemStoreDao;

    public ItemStoreController(ItemStoreDao itemStoreDao) {
        this.itemStoreDao = itemStoreDao;
    }

    @RequestMapping(path = "/items_store/{itemId}", method = RequestMethod.GET)
    public ItemStore getItemByItemId(@PathVariable int itemId) {
        return itemStoreDao.getItemByItemId(itemId);
    }
    @RequestMapping(path = "/items_store", method = RequestMethod.GET)
    public List<ItemStore> getAllStoreItems() {
        return itemStoreDao.listAllStoreItems();
    }

}

