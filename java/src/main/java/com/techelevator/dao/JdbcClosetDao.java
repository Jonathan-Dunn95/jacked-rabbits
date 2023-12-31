package com.techelevator.dao;

import com.techelevator.model.Closet;
import com.techelevator.model.ItemStore;
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

// Revise
    @Override
    public List<ItemStore> getItemsByMascotId(int mascotId) {
        String sql = "SELECT item_id FROM closet WHERE mascot_id = ?;";
        String sqlItem = "SELECT * FROM items_store WHERE item_id = ?";
        List<Integer> itemsIds = new ArrayList<>();
        List<ItemStore> items = new ArrayList<>();
        SqlRowSet itemIds =  jdbcTemplate.queryForRowSet(sql, mascotId);
        while(itemIds.next()) {
            itemsIds.add(itemIds.getInt("item_id"));
        }
        for(int itemId : itemsIds) {
            SqlRowSet rowSetItem = jdbcTemplate.queryForRowSet(sqlItem, itemId);
            if(rowSetItem.next()) {
                items.add(mapRowToItemStore(rowSetItem));
            }
        }
        return items;
    }

//    @Override
//    public void updateClosetItem(Closet closetItem) {
//        String sql = "UPDATE closet SET mascot_id = ?, shirt = ?, shoes = ?, hat = ?, accessory = ?, background = ? " +
//                "WHERE closet_id = ?;";
//        try {
//            jdbcTemplate.update(sql, closetItem.getMascotId(), closetItem.getMascotId());
//        } catch (Exception e) {
//            System.err.println("An error occurred while updating item");
//        }
//    }

// Revise
    @Override
    public void addItemToCloset(int itemId, int mascotId) {
        String sql = "INSERT INTO closet (mascot_id, item_id) VALUES (?, ?);";
        try {
            jdbcTemplate.update(sql, mascotId, itemId);
        } catch (Exception e) {
            System.out.println ("An error occurred while adding item to closet" + e.getCause());
        }
    }

    private Closet mapRowToCloset(SqlRowSet rs) {
        Closet closet = new Closet();
        closet.setMascotId(rs.getInt("mascot_id"));
        closet.setItemId(rs.getInt("item_id"));
        return closet;
    }

    private ItemStore mapRowToItemStore(SqlRowSet rs) {
        ItemStore itemStore = new ItemStore();
        itemStore.setItemId(rs.getInt("item_id"));
        itemStore.setImgURL(rs.getString("img_url"));
        return itemStore;
    }
}

