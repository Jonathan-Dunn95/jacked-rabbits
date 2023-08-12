package com.techelevator.controller;

import com.techelevator.dao.MascotSelectionDao;
import com.techelevator.model.MascotSelection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascot-selection")
@CrossOrigin
public class MascotSelectionController {

    private MascotSelectionDao mascotSelectionDao;

    public MascotSelectionController(MascotSelectionDao mascotSelectionDao) {
        this.mascotSelectionDao = mascotSelectionDao;
    }

    @GetMapping
    public List<MascotSelection> getAllMascotSelections() {
        return mascotSelectionDao.getAllMascotSelections();
    }

    @GetMapping("/{mascotSelectionId}")
    public MascotSelection getMascotSelectionById(@PathVariable int mascotSelectionId) {
        return mascotSelectionDao.getMascotSelectionById(mascotSelectionId);
    }

    @GetMapping("/img-url/{imgURL}")
    public MascotSelection getMascotSelectionByImgURL(@PathVariable String imgURL) {
        return mascotSelectionDao.getMascotSelectionByImgURL(imgURL);
    }
}

