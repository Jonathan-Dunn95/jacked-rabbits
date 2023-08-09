package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Kid;
import com.techelevator.model.Mascot;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMascotDao implements MascotDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMascotDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Mascot> getAllMascot(){
        List<Mascot> allMascots  = new ArrayList<>();
        String sql = "SELECT * from mascot;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            Mascot mascot = mapRowToMascot(result);
            allMascots.add(mascot);
        }
        return allMascots;
    }

    @Override
    public Mascot getMascotById(int mascotId) {
        Mascot mascot = null;
        String sql = "SELECT mascot_id, kids_id, shirt, shoes, hat, accessory, background, closet_id " +
                "FROM mascot WHERE mascot_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mascotId);
            if (results.next()) {
                mascot = mapRowToMascot(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mascot;
    }

    @Override
    public Mascot createMascot(Mascot mascot) {
        String sql = "INSERT INTO mascot (mascot_id, kids_id, shirt, shoes, hat, accessory, background, closet_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING mascot_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, mascot.getMascotId(), mascot.getKidId(),
                mascot.getShirt(), mascot.getShoes(), mascot.getHat(),
                mascot.getAccessory(), mascot.getBackground(), mascot.getClosetId());

        return getMascotById(newId);
    }

    @Override
    public List<Mascot> getMascotByKidId(int kidId) {
        List<Mascot> mascotList = new ArrayList<>();
        String sql = "SELECT mascot_id, kids_id, shirt, shoes, hat, accessory, background, " +
                "closet_id FROM mascot WHERE kids_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Mascot mascot = mapRowToMascot(results);
            mascotList.add(mascot);
        }
        return mascotList;
    }

    @Override
    public void updateMascot(Mascot mascot) {
        String sql = "UPDATE mascot "+
                "SET kids_id = ?, shirt = ?, shoes = ?, hat = ?, accessory = ?, background = ?, closet_id = ?" +
                "WHERE mascot_id = ?;";
        jdbcTemplate.update(sql, mascot.getKidId(), mascot.getShirt(), mascot.getShoes(), mascot.getHat(),
                mascot.getAccessory(), mascot.getBackground(), mascot.getClosetId());
    }

    @Override
    public void deleteMascot(int mascotId) {
        String sql = "DELETE FROM mascot WHERE mascot_id = ?;";
        jdbcTemplate.update(sql, mascotId);
    }


    private Mascot mapRowToMascot(SqlRowSet rs) {
        Mascot mascot = new Mascot();
        mascot.setMascotId(rs.getInt("mascot_id"));
        mascot.setKidId(rs.getInt("kids_id"));
        mascot.setShirt(rs.getInt("shirt"));
        mascot.setShoes(rs.getInt("shoes"));
        mascot.setHat(rs.getInt("hat"));
        mascot.setAccessory(rs.getInt("accessory"));
        mascot.setBackground(rs.getInt("background"));
        mascot.setClosetId(rs.getInt("closet_id"));
        return mascot;
    }
}
