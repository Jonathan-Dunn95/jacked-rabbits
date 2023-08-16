package com.techelevator.controller;

import com.techelevator.dao.ClosetDao;
import com.techelevator.model.Closet;
import com.techelevator.model.ItemStore;
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


    @RequestMapping(path = "{mascotId}", method = RequestMethod.GET)
    public List<ItemStore> getItemsByMascotId(@PathVariable int mascotId) {
        return closetDao.getItemsByMascotId(mascotId);
    }
// Needs review
    @RequestMapping(path = "update/", method = RequestMethod.POST)
    public void addItemToCloset(@RequestBody Closet closet) {
        closetDao.addItemToCloset(closet.getItemId(), closet.getMascotId());
    }

//    @RequestMapping(path = "{closetId}", method = RequestMethod.PUT)
//    public void updateClosetItem(@PathVariable int closetId, @RequestBody Closet closetItem) {
//        closetItem.setCloset_id(closetId);
//        closetDao.updateClosetItem(closetItem);
//    }
}
