package com.techelevator.dao;

import com.techelevator.model.Closet;

import java.util.List;

public interface ClosetDao {

    List<Integer> getItemsByMascotId(int mascotId);

    void addItemToCloset(int itemId, int mascotId);

}



