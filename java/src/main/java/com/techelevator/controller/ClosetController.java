package com.techelevator.controller;

import com.techelevator.dao.ClosetDao;
import com.techelevator.model.Closet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/closet")
@CrossOrigin
public class ClosetController {

    private ClosetDao closetDao;

    public ClosetController(ClosetDao closetDao) {
        this.closetDao = closetDao;
    }

    @GetMapping
    public List<Closet> getAllClosetItems() {
        return closetDao.getAllClosetItems();
    }

    @GetMapping("/{closetId}")
    public Closet getClosetItemById(@PathVariable int closetId) {
        return closetDao.getClosetItemById(closetId);
    }

    @PostMapping("/add")
    public void addItemToCloset(@RequestParam int item_id, @RequestParam int mascot_id) {
        closetDao.addItemToCloset(item_id, mascot_id);
    }

    @PutMapping("/{closetId}")
    public void updateClosetItem(@PathVariable int closetId, @RequestBody Closet closetItem) {
        closetItem.setCloset_id(closetId);
        closetDao.updateClosetItem(closetItem);
    }
}
