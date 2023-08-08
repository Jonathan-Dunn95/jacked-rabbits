package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.KidDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(path = "/kids", method = RequestMethod.POST)
    public void createKid(@RequestBody KidRequestDto kidRequestDto) {
        kidDao.createKid(kidRequestDto);
    }
//    @RequestMapping(path = "/kids", method = RequestMethod.POST)
//    public ResponseEntity<Kid> addKid(@Valid @RequestBody KidRequestDto kidRequest) {
//        Kid newKid = new Kid(kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getCarrots());
//        Kid createdKid = kidDao.createKid(kidRequest);
//
//        if (createdKid == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kid creation failed.");
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdKid);
//    }
}
