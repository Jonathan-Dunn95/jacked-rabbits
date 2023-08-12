package com.techelevator.controller;

import com.techelevator.dao.ClosetDao;
import com.techelevator.model.Closet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/closet/")
@CrossOrigin
public class ClosetController {

    private ClosetDao closetDao;

    public ClosetController(ClosetDao closetDao) {
        this.closetDao = closetDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Closet> getAllClosetItems() {
        return closetDao.getAllClosetItems();
    }

    @RequestMapping(path = "{closetId}", method = RequestMethod.GET)
    public Closet getClosetItemById(@PathVariable int closetId) {
        return closetDao.getClosetItemById(closetId);
    }
// Needs review
    @RequestMapping(path = "add/{mascotId}", method = RequestMethod.POST)
    public void addItemToCloset(@RequestParam int item_id, @RequestParam int mascot_id) {
        closetDao.addItemToCloset(item_id, mascot_id);
    }

    @RequestMapping(path = "{closetId}", method = RequestMethod.PUT)
    public void updateClosetItem(@PathVariable int closetId, @RequestBody Closet closetItem) {
        closetItem.setCloset_id(closetId);
        closetDao.updateClosetItem(closetItem);
    }
}
