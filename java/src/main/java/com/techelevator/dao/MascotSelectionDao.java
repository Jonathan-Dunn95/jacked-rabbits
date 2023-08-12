package com.techelevator.dao;

import com.techelevator.model.MascotSelection;

import java.util.List;

public interface MascotSelectionDao {

    List<MascotSelection> getAllMascotSelections();

    MascotSelection getMascotSelectionById(int mascotSelectionId);

    MascotSelection getMascotSelectionByImgURL(String imgURL);
}
