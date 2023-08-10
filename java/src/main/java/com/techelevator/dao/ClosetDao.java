package com.techelevator.dao;
import com.techelevator.model.Closet;
import com.techelevator.model.Mascot;

import java.util.List;

public interface ClosetDao {
    List<Closet> getAllClosetItems();
    void addItemToCloset(int item_id, int mascot_id);

    List<Closet> getItemsByKidId(int kidId);
    void deleteItem(int itemId);

}
