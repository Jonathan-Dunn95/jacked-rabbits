package com.techelevator.model;

public class MascotSelection {

    private int mascotSelectionId;
    private String imgURL;

    public MascotSelection() {}

    public MascotSelection(int mascotSelectionId, String imgURL) {
        this.mascotSelectionId = mascotSelectionId;
        this.imgURL = imgURL;
    }

    public int getMascotSelectionId() {
        return mascotSelectionId;
    }

    public void setMascotSelectionId(int mascotSelectionId) {
        this.mascotSelectionId = mascotSelectionId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
