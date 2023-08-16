package com.techelevator.dao;

import com.techelevator.model.Closet;
import com.techelevator.model.ItemStore;

import java.util.List;

public interface ClosetDao {

    List<ItemStore> getItemsByMascotId(int mascotId);

    void addItemToCloset(int itemId, int mascotId);

}



