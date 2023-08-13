package com.techelevator.controller;

import com.techelevator.dao.MascotSelectionDao;
import com.techelevator.model.MascotSelection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MascotSelectionController {

    private MascotSelectionDao mascotSelectionDao;

    public MascotSelectionController(MascotSelectionDao mascotSelectionDao) {
        this.mascotSelectionDao = mascotSelectionDao;
    }

    @RequestMapping(path = "/mascot_selection", method = RequestMethod.GET)
    public List<MascotSelection> getAllMascotSelections() {
        return mascotSelectionDao.getAllMascotSelections();
    }

    @RequestMapping(path = "/mascot_selection/{mascotSelectionId}", method = RequestMethod.GET)
    public MascotSelection getMascotSelectionById(@PathVariable int mascotSelectionId) {
        return mascotSelectionDao.getMascotSelectionById(mascotSelectionId);
    }

    @RequestMapping(path = "/mascot_selection/img_url/{imgURL}", method = RequestMethod.GET)
    public MascotSelection getMascotSelectionByImgURL(@PathVariable String imgURL) {
        return mascotSelectionDao.getMascotSelectionByImgURL(imgURL);
    }
}

