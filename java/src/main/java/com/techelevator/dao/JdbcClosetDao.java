package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Closet;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClosetDao implements ClosetDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcClosetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Closet> getAllClosetItems() {
        List<Closet> closetItems = new ArrayList<>();
        String sql = "SELECT item_id, mascot_id FROM closet;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                closetItems.add(mapRowToClosetItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return closetItems;
    }

    @Override
    public void addItemToCloset(int item_id, int mascot_id) {
        String sql = "INSERT INTO closet (item_id, mascot_id) VALUES (?, ?);";
        try {
            jdbcTemplate.update(sql, item_id, mascot_id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }
    // get item by kid_id
    @Override
    public List<Closet> getItemsByKidId(int kidId) {
        List<Closet> items = new ArrayList<>();
        String sql = "SELECT * FROM closet " +
                "JOIN mascot ON closet.closet_id = mascot.closet_id" +
                "JOIN kids ON kids.kids_id = mascot.kids_id" +
                "WHERE kids.kids_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kidId);
            while(results.next()){
                items.add(mapRowToClosetItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return items;

    }

    @Override
    public void deleteItem(int itemId) {
        String sql = "DELETE FROM closet WHERE item_id = ?;";
        jdbcTemplate.update(sql, itemId);
    }



    private Closet mapRowToClosetItem(SqlRowSet rs) {
        Closet closetItem = new Closet();
        closetItem.setItem_id(rs.getInt("item_id"));
        closetItem.setMascot_id(rs.getInt("mascot_id"));
        return closetItem;
    }
}