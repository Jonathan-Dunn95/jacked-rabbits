package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface KidDao {

    Kid getKidById(int id);

    List<Kid> getAllKids();

    Kid createKid(KidRequestDto kidRequest, int userId);

    void deleteKid(int kidId);

    void updateKid(Kid kid);

    Activity getActivityById(int id);
}
