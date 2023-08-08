package com.techelevator.dao;

import com.techelevator.model.Kid;
import com.techelevator.model.KidRequestDto;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface KidDao {
    Kid getKidById(int id);

    List<Kid> listKidsById(int id);

    Kid createKid(KidRequestDto kidRequest);


}
