package com.techelevator.controller;

import com.techelevator.dao.KidDao;
import com.techelevator.dao.MascotDao;
import com.techelevator.model.Kid;
import com.techelevator.model.Mascot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@CrossOrigin
public class MascotController {
    private MascotDao mascotDao;

    private KidDao kidDao;

    public MascotController(MascotDao mascotDao) {
        this.mascotDao = mascotDao;
    }

    @RequestMapping(path = "/mascot", method = RequestMethod.GET)
    public List<Mascot> getAllMascot(){
        return mascotDao.getAllMascot();
    }

    @RequestMapping(path = "/mascot/{mascotId}", method = RequestMethod.GET)
    public Mascot getMascotById(int mascotId){
        return mascotDao.getMascotByMascotId(mascotId);
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

    // calculate carrot required

//    @RequestMapping(path = "/carrots-required/{optionId}", method = RequestMethod.GET)
//    public ResponseEntity<Integer> calculateCarrotsRequired(@PathVariable int optionId) {
//
//    }
    @RequestMapping(path = "/mascot/{mascotId}/customize", method = RequestMethod.PUT)
    public void customizeMascot(@PathVariable int mascotId, @RequestBody Mascot mascot) {
        // Check if the child has enough carrots
        Kid kid = kidDao.getKidById(mascot.getKidId());
        int requiredCarrots = calculateCarrotsRequiredForCustomization(mascot);

        if (kid.getCarrots() >= requiredCarrots) {
            // Deduct carrots and update mascot customization in the database
            kid.setCarrots(kid.getCarrots() - requiredCarrots);
            mascotDao.updateMascotCustomization(mascotId, mascot);
            kidDao.updateKid(kid);
        } else {
            // Handle insufficient carrots error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient carrots for customization.");
        }
    }
    private int calculateCarrotsRequiredForCustomization(Mascot mascot) {
        int totalCarrotsRequired = 0;

        // Calculate carrots for each option based on carrot
        totalCarrotsRequired += getCarrotsForOption(mascot.getShirt());
        totalCarrotsRequired += getCarrotsForOption(mascot.getShoes());
        totalCarrotsRequired += getCarrotsForOption(mascot.getHat());
        totalCarrotsRequired += getCarrotsForOption(mascot.getAccessory());
        totalCarrotsRequired += getCarrotsForOption(mascot.getBackground());

        return totalCarrotsRequired;
    }
    // for front end: when user click on option id to choose what id items they want to buy.
    // for backend: optionId use for calculate carrot required for the option
    private int getCarrotsForOption(int optionId) {
        int carrotsRequired = 0;

        if (optionId >= 200 && optionId <= 250) {
            // Shirt id (200-250): 2 carrot
            carrotsRequired = 2;
        } else if (optionId >= 251 && optionId <= 300) {
            // Shoes (251-300): 3 carrots
            carrotsRequired = 3;
        } else if (optionId >= 301 && optionId <= 350) {
            // Hat  (301-350): 4 carrots
            carrotsRequired = 4;
        } else if (optionId >= 351 && optionId <= 400) {
            // Accessory  (351-400): 5 carrots
            carrotsRequired = 5;
        } else if (optionId >= 401 && optionId <= 450) {
            // Background  (401-450): 6 carrots
            carrotsRequired = 6;
        }
        return carrotsRequired;
    }
}
