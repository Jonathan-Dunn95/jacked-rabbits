package com.techelevator.dao;

import com.techelevator.model.Mascot;
import com.techelevator.model.MascotRequestDto;

import java.util.List;

public interface MascotDao {
    List<Mascot> getAllMascot();

    Mascot getMascotByMascotId(int mascotId);

    Mascot getMascotByKidId(int kidId);

    Mascot createMascot(Mascot mascot, int mascotId);

    void updateMascot(Mascot mascot);

    void deleteMascot(int mascotId);

    void updateMascotCustomization(int mascotId, Mascot mascot);


}
