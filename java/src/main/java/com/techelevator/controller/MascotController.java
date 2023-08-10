package com.techelevator.controller;

import com.techelevator.dao.MascotDao;
import com.techelevator.model.Mascot;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class MascotController {
    private MascotDao mascotDao;


    public MascotController(MascotDao mascotDao) {
        this.mascotDao = mascotDao;
    }


    @RequestMapping(path = "/mascot", method = RequestMethod.GET)
    public List<Mascot> getAllMascot(){
        return mascotDao.getAllMascot();
    }

    @RequestMapping(path = "/mascot/{mascotId}", method = RequestMethod.GET)
    public Mascot getMascotById(int mascotId){
        return mascotDao.getMascotById(mascotId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/mascot", method = RequestMethod.POST)
    public Mascot createMascot(@RequestBody Mascot mascot){
        return mascotDao.createMascot(mascot);
    }

    @RequestMapping(path = "/mascot/{kidId}", method = RequestMethod.GET)
    public Mascot getMascotByKidId(@PathVariable int kidId) {
        return mascotDao.getMascotByKidId(kidId);
    }


    @RequestMapping(path = "/update/{mascotId}", method = RequestMethod.PUT)
    public void updateMascot(@RequestBody Mascot mascot){
        this.mascotDao.updateMascot(mascot);
    }
    @RequestMapping(path = "/mascot/{mascotId}", method = RequestMethod.DELETE)
    public void deleteMascot(@PathVariable int mascotId){
        mascotDao.deleteMascot(mascotId);
    }



}
