package com.techelevator.controller;

import com.techelevator.dao.KidDao;
import com.techelevator.dao.MascotDao;
import com.techelevator.model.Kid;
import com.techelevator.model.Mascot;
import com.techelevator.model.MascotSelection;
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



    public MascotController(MascotDao mascotDao, KidDao kidDao) {
        this.mascotDao = mascotDao;
        this.kidDao = kidDao;
    }

    @RequestMapping(path = "/mascot", method = RequestMethod.GET)
    public List<Mascot> getAllMascot() {
        return mascotDao.getAllMascot();
    }

    @RequestMapping(path = "/mascot/{mascotId}", method = RequestMethod.GET)
    public Mascot getMascotById(@PathVariable int mascotId){

        return mascotDao.getMascotByMascotId(mascotId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/mascot", method = RequestMethod.POST)
    public Mascot createMascot(@RequestBody Mascot mascot){
        return mascotDao.createMascot(mascot, mascot.getMascotId());
    }

    @RequestMapping(path = "/mascot/by-kid/{kidId}", method = RequestMethod.GET)
    public Mascot getMascotByKidId(@PathVariable int kidId) {
        return mascotDao.getMascotByKidId(kidId);
    }

    @RequestMapping(path = "/mascot/update/{mascotId}", method = RequestMethod.PUT)
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

    // Review
    @RequestMapping(path = "/mascot/{mascotId}/customize", method = RequestMethod.PUT)
    public void customizeMascot(@PathVariable int mascotId, @RequestBody Mascot mascots) {
        // get the mascot --> customized
        Mascot mascot = mascotDao.getMascotByMascotId(mascotId);
        // check if mascot exists
        if (mascot == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mascot not found.");
        }

        // Check if the child has enough carrots
        Kid kid = kidDao.getKidById(mascot.getKidId());
        int requiredCarrots = calculateCarrotsRequiredForCustomization(mascot);

        if (kid.getCarrots() >= requiredCarrots) {
            // Deduct carrots and update mascot customization in the database
            kid.setCarrots(kid.getCarrots() - requiredCarrots);
            // update mascot
            mascot.setShirt(mascots.getShirt());
            mascot.setShoes(mascots.getShoes());
            mascot.setHat(mascots.getHat());
            mascot.setAccessory(mascots.getAccessory());
            mascot.setBackground(mascots.getBackground());
            mascot.setMascotSelectionId(mascots.getMascotSelectionId());
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
    // for front end: when user click on item id to choose what id items they want to buy.

    // for backend: itemId use for calculate carrot required for the option

    private int getCarrotsForOption(int itemId) {
        int carrotsRequired = 0;

        if (itemId >= 1 && itemId <= 12) {
            // Shirt id (1-12): 2 carrot
            carrotsRequired = 2;
        } else if (itemId >= 13 && itemId <= 24) {
            // Shoes (13-24): 3 carrots
            carrotsRequired = 3;

        } else if (itemId >= 25 && itemId<= 36) {
            // Hat  (301-350): 4 carrots
            carrotsRequired = 4;
        } else if (itemId >= 49 && itemId <= 60) {
            // Accessory  (351-400): 5 carrots
            carrotsRequired = 5;

        } else if (itemId >= 25 && itemId <= 36) {
            // Hat  (25-36): 4 carrots
            carrotsRequired = 4;
        } else if (itemId >= 37 && itemId <= 48) {
            // Accessory  (37-48): 5 carrots
            carrotsRequired = 5;
        } else if (itemId >= 49 && itemId <= 60) {
            // Background  (49-60): 6 carrots
            carrotsRequired = 6;
        }
        return carrotsRequired;
    }
}
