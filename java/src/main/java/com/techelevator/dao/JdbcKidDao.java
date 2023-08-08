package com.techelevator.dao;

import com.techelevator.model.Kid;
import com.techelevator.model.KidRequestDto;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcKidDao implements KidDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcKidDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Kid getKidById(int id) {
        return null;
    }

    @Override
    public List<Kid> listKidsById(int id) {
        return null;
    }

    @Override
    public Kid createKid(KidRequestDto kidRequest) {
        String sql = "INSERT INTO kids (user_id, username, carrots) VALUES (?, ?, ?) RETURNING kid_id";
        Integer kidId = jdbcTemplate.queryForObject(sql, Integer.class, kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getCarrots());

        if (kidId != null) {
            return new Kid(kidId, kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getCarrots());
        } else {
            return null;
        }
    }


}
