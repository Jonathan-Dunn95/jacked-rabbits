package com.techelevator.controller;

import com.techelevator.dao.MascotDao;
import com.techelevator.model.Mascot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MascotController {
    private MascotDao mascotDao;

    public MascotController(MascotDao mascotDao) {
        this.mascotDao = mascotDao;
    }
    

}
