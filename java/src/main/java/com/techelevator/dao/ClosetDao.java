package com.techelevator.dao;

import com.techelevator.model.Closet;

import java.util.List;

public interface ClosetDao {

    List<Closet> getAllClosetItems();
    Closet getClosetItemById(int closetItemId);
    void updateClosetItem(Closet closetItem);
    void addItemToCloset(int item_id, int mascot_id);


}



