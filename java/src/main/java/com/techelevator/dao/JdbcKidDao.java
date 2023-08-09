package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Kid;
import com.techelevator.model.KidRequestDto;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcKidDao implements KidDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcKidDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Kid getKidById(int kidId) {
        Kid kid = null;
        String sql = "SELECT kids_id, user_id, username, password_hash, carrots FROM kids WHERE kids_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kidId);
            if (results.next()) {
                kid = mapRowToKid(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return kid;
    }

    @Override
    public List<Kid> getAllKids() {
        List<Kid> allKids  = new ArrayList<>();
        String sql = "SELECT * from kids;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            Kid kid = mapRowToKid(result);
            allKids.add(kid);
        }
        return allKids;
    }



    @Override
    public Kid createKid(KidRequestDto kidRequest) {
        String sql = "INSERT INTO kids (user_id, username, password_hash, carrots) VALUES (?, ?, ?, ?) RETURNING kids_id;";
        Integer kidId = jdbcTemplate.queryForObject(sql, Integer.class, kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getPasswordHash(), kidRequest.getCarrots());

        if (kidId != null) {
            return new Kid(kidId, kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getCarrots(), kidRequest.getPasswordHash());
        } else {
            return null;
        }
    }

    @Override
    public void deleteKid(int kidId) {
        String sql = "DELETE FROM kids WHERE kids_id = ?";
        jdbcTemplate.update(sql, kidId);
    }

    @Override
    public void updateKid(Kid kid) {
        String sql = "UPDATE kids " +
                "SET username = ? " +
                "WHERE user_id = ?;";
        jdbcTemplate.update(sql, kid.getUsername());
    }

    private Kid mapRowToKid(SqlRowSet rs) {
        Kid kid = new Kid();
        kid.setKidId(rs.getInt("kids_id"));
        kid.setParentId(rs.getInt("user_id"));
        kid.setUsername(rs.getString("username"));
        kid.setCarrots(rs.getInt("carrots"));
        return kid;
    }
}
