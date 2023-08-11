package com.techelevator.controller;


import com.techelevator.dao.ClosetDao;
import com.techelevator.model.Closet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClosetController {
    private ClosetDao closetDao;

    public ClosetController(ClosetDao closetDao) {
        this.closetDao = closetDao;
    }

    @RequestMapping(path = "/closet", method = RequestMethod.GET)
    public List<Closet> getAllClosetItems(){
        return closetDao.getAllClosetItems();
    }


    @RequestMapping(path = "/closet/{kidId}", method = RequestMethod.GET)
    public List<Closet> getItemsByKidId(@PathVariable int kidId) {
        return closetDao.getItemsByKidId(kidId);
    }


    @RequestMapping(path = "/closet/add", method = RequestMethod.POST)
    public void addItemToCloset(@RequestParam int item_id, int mascot_id){
        this.closetDao.addItemToCloset(item_id, mascot_id);
    }

    @RequestMapping(path = "/closet/{item_id}")
    public void deleteItem(@PathVariable int item_id) {
        closetDao.deleteItem(item_id);
    }


}
