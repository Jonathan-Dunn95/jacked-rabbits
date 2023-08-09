package com.techelevator.dao;

import com.techelevator.model.Mascot;

import java.util.List;

public interface MascotDao {
    List<Mascot> getAllMascot();

    Mascot getMascotById(int mascotId);

    Mascot createMascot(Mascot mascot);

    List<Mascot> getMascotByKidId(int kidId);

    void updateMascot(Mascot mascot);

    void deleteMascot(int mascotId);


}
