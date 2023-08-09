package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.KidDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class KidController {

    private KidDao kidDao;

    public KidController(KidDao kidDao) {
        this.kidDao = kidDao;
    }

    @RequestMapping(path = "/kids/{kidId}", method = RequestMethod.GET)
    public Kid getKidById(@PathVariable int kidId) {
        return kidDao.getKidById(kidId);
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public List<Kid> getAllKids(@PathVariable int id){
        return kidDao.getAllKids();
    }

    //@PreAuthorize("hasRole(ROLE_PARENT)")
    @RequestMapping(path = "/kids", method = RequestMethod.POST)
    public void createKid(@RequestBody KidRequestDto kidRequestDto) {
        kidDao.createKid(kidRequestDto);
    }


    //@PreAuthorize("hasRole(ROLE_PARENT)")
    @RequestMapping(path = "/users/{id}/update/{kidId}", method = RequestMethod.PUT)
    public void updateKid (@RequestBody Kid kid) {
        this.kidDao.updateKid(kid);
    }

    //@PreAuthorize("hasRole(ROLE_PARENT)")
    @RequestMapping(path = "/users/{id}/kids/{kidId}", method = RequestMethod.DELETE)
    public void deleteKid (@PathVariable int kidId) {
        kidDao.deleteKid(kidId);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/kids/{id}/activity", method = RequestMethod.GET)
    public Activity getActivityById(@PathVariable int id){

        return kidDao.getActivityById(id);
    }



}
