package com.techelevator.dao;

import com.techelevator.model.Mascot;

import java.util.List;

public interface MascotDao {
    List<Mascot> getAllMascot();

    Mascot getMascotById(int mascotId);

    Mascot getMascotByKidId(int kidId);

    Mascot createMascot(Mascot mascot);

    void updateMascot(Mascot mascot);

    void deleteMascot(int mascotId);


}
