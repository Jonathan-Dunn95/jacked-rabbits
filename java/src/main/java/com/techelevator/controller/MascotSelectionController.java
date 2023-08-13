package com.techelevator.controller;

import com.techelevator.dao.MascotSelectionDao;
import com.techelevator.model.MascotSelection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascot_selection")

@CrossOrigin
public class MascotSelectionController {

    private MascotSelectionDao mascotSelectionDao;

    public MascotSelectionController(MascotSelectionDao mascotSelectionDao) {
        this.mascotSelectionDao = mascotSelectionDao;
    }

    @RequestMapping(path = "", method =  RequestMethod.GET)
    public List<MascotSelection> getAllMascotSelections() {
        return mascotSelectionDao.getAllMascotSelections();
    }

    @RequestMapping(path = "/{mascotSelectionId}", method = RequestMethod.GET)
    public MascotSelection getMascotSelectionById(@PathVariable int mascotSelectionId) {
        return mascotSelectionDao.getMascotSelectionById(mascotSelectionId);
    }

    @RequestMapping(path = "/{imgURL}", method = RequestMethod.GET)
    public MascotSelection getMascotSelectionByImgURL(@PathVariable String imgURL) {
        return mascotSelectionDao.getMascotSelectionByImgURL(imgURL);
    }
}

