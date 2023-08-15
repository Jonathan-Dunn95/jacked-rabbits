package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        String sql = "SELECT kids_id, user_id, username, password_hash, carrots FROM kids WHERE kids_id = ?;";
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
    public List<Kid> getAllKids(int parentId) {
        List<Kid> allKids  = new ArrayList<>();
        String sql = "SELECT * from kids WHERE user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parentId);
        while(result.next()) {
            Kid kid = mapRowToKid(result);
            allKids.add(kid);
        }
        return allKids;
    }



    @Override
    public Kid createKid(KidRequestDto kidRequest, int userId) {
        String sql = "INSERT INTO kids (kids_id, user_id, username, password_hash, carrots, play_time_seconds) VALUES (?, ?, ?, ?, ?, ?) RETURNING kids_id;";
        String password_hash = new BCryptPasswordEncoder().encode(kidRequest.getPasswordHash());
        Integer kidId = jdbcTemplate.queryForObject(sql, Integer.class, userId, kidRequest.getParentId(), kidRequest.getUsername(), password_hash, kidRequest.getCarrots(), kidRequest.getPlayTime());
        if (kidId != null) {
            createActivity(kidId);
//            createCloset();
////            createMascot();
            return new Kid(kidId, kidRequest.getParentId(), kidRequest.getUsername(), kidRequest.getCarrots(), kidRequest.getPasswordHash(), kidRequest.getPlayTime(), "ROLE_KID");
        } else {
            return null;
        }
    }

    @Override
    public void deleteKid(int kidId) {
        String sqlActivity = "DELETE FROM activity WHERE kids_id = ?;";
        String sqlKids = "DELETE FROM kids WHERE kids_id = ?;";
        String sqlUser = "DELETE FROM users WHERE user_id = ?;";
        jdbcTemplate.update(sqlActivity, kidId);
        jdbcTemplate.update(sqlKids, kidId);
        jdbcTemplate.update(sqlUser, kidId);
    }

    @Override
    public void updateKid(Kid kid) {
        String sql = "UPDATE kids " +
                "SET username = ?, carrots = ?, play_time_seconds = ?" +
                "WHERE kids_id = ?;";
        jdbcTemplate.update(sql, kid.getUsername(), kid.getCarrots(), kid.getPlayTime(), kid.getKidId());
    }

    @Override
    public Activity getActivityById(int id) {
        Activity activity = null;
        String sql = "SELECT * FROM activity WHERE kids_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if (results.next()) {
            activity = mapRowToActivity(results);
        }
        return activity;
    }

    private Kid mapRowToKid(SqlRowSet rs) {
        Kid kid = new Kid();
        kid.setKidId(rs.getInt("kids_id"));
        kid.setParentId(rs.getInt("user_id"));
        kid.setUsername(rs.getString("username"));
        kid.setCarrots(rs.getInt("carrots"));
        return kid;
    }

    private Activity mapRowToActivity(SqlRowSet rs) {
        Activity activity = new Activity();
        activity.setKidId(rs.getInt("kids_id"));
        activity.setSteps(rs.getInt("steps"));
        activity.setMinutes(rs.getInt("minutes"));
        return activity;
    }

    private void createActivity(int kidId) {
        System.out.println('1');
        String sql = "INSERT INTO activity (kids_id,steps,minutes) VALUES (?,?,?)";
        Activity activity = new Activity();
        activity.setSteps(0);
        activity.setMinutes(0);
        jdbcTemplate.update(sql,kidId,activity.getSteps(),activity.getMinutes());
    }

    private void createCloset(int kidId) {
        System.out.println('3');
        String sql = "INSERT INTO create (kids_id,steps,minutes) VALUES (?,?,?)";
        Closet closet = new Closet();
//        closet.setCloset_id();
    }

    private void createMascot(int kidId) {
        System.out.println('3');
        String sql = "INSERT INTO mascot (mascot_id,kids_id, shirt, shoes, hat, accessory, background, closet_id) VALUES (?,?,?,?,?,?)";
        Mascot mascot = new Mascot();
        mascot.setShirt(0);
        mascot.setShoes(0);
        mascot.setHat(0);
        mascot.setAccessory(0);
        mascot.setBackground(0);
//        mascot.setClosetId(0);
        jdbcTemplate.update(sql,kidId,kidId,mascot.getShirt(),mascot.getShoes(),mascot.getHat(),mascot.getAccessory(),mascot.getBackground());
    }
}
