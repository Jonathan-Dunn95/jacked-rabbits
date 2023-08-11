package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface KidDao {

    Kid getKidById(int id);

    List<Kid> getAllKids();

    Kid createKid(KidRequestDto kidRequest);

    void deleteKid(int kidId);

    void updateKid(Kid kid);

    Activity getActivityById(int id);

    Kid getKidByUsername(String username);
}
