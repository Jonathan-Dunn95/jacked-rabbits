package com.techelevator.dao;

import com.techelevator.model.Closet;
import com.techelevator.model.MascotSelection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClosetDao implements ClosetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClosetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Closet> getAllClosetItems() {
        String sql = "SELECT * FROM closet;";
        List<Closet> allClosetItems = new ArrayList<>();
        try {
            jdbcTemplate.query(sql, resultSet -> {
                Closet closet = new Closet();
                closet.setCloset_id(resultSet.getInt("closet_id"));
                closet.setMascot_id(resultSet.getInt("mascot_id"));
                closet.setShirt(resultSet.getInt("shirt"));
                closet.setShoes(resultSet.getInt("shoes"));
                closet.setHat(resultSet.getInt("hat"));
                closet.setAccessory(resultSet.getInt("accessory"));
                closet.setBackground(resultSet.getInt("background"));
                allClosetItems.add(closet);
            });
        } catch (Exception e) {
            System.err.println("An error occurred while retrieving all closet items: ");
        }
        return allClosetItems;
    }

    @Override
    public Closet getClosetItemById(int closetItemId) {
        String sql = "SELECT * FROM closet WHERE closet_id = ?;";
        Closet closetItem = null;
        try {
            closetItem = jdbcTemplate.queryForObject(sql, new Object[]{closetItemId}, (resultSet, rowNum) -> {
                Closet closet = new Closet();
                closet.setCloset_id(resultSet.getInt("closet_id"));
                closet.setMascot_id(resultSet.getInt("mascot_id"));
                closet.setShirt(resultSet.getInt("shirt"));
                closet.setShoes(resultSet.getInt("shoes"));
                closet.setHat(resultSet.getInt("hat"));
                closet.setAccessory(resultSet.getInt("accessory"));
                closet.setBackground(resultSet.getInt("background"));
                return closet;
            });
        } catch (Exception e) {
            System.err.println("An error occurred while retrieving closet item");
        }
        return closetItem;
    }

    @Override
    public void updateClosetItem(Closet closetItem) {
        String sql = "UPDATE closet SET mascot_id = ?, shirt = ?, shoes = ?, hat = ?, accessory = ?, background = ? " +
                "WHERE closet_id = ?;";
        try {
            jdbcTemplate.update(sql, closetItem.getMascot_id(), closetItem.getShirt(), closetItem.getShoes(),
                    closetItem.getHat(), closetItem.getAccessory(), closetItem.getBackground(), closetItem.getCloset_id());
        } catch (Exception e) {
            System.err.println("An error occurred while updating item");
        }
    }


    @Override
    public void addItemToCloset(int item_id, int mascot_id) {
        String sql = "INSERT INTO closet (item_id, mascot_id) VALUES (?, ?);";
        try {
            jdbcTemplate.update(sql, item_id, mascot_id);
        } catch (Exception e) {
            System.err.println("An error occurred while adding item to closet");
        }
    }

    private Closet mapRowToCloset(SqlRowSet rs) {
        Closet closet = new Closet();
        closet.setCloset_id(rs.getInt("closet_id"));
        closet.setMascot_id(rs.getInt("mascot_id"));
        return closet;
    }

}
