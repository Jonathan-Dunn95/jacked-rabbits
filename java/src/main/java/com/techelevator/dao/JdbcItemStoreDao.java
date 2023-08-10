package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ItemStore;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemStoreDao implements ItemStoreDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcItemStoreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public ItemStore getItemByItemId(int itemId) {
        ItemStore itemStore = null;
        String sql = "SELECT item_id, item_type, item_name FROM items_store WHERE item_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
            if(results.next()){
                itemStore = mapRowtoItemStore(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return itemStore;
    }

    @Override
    public ItemStore getItemByItemName(String itemName) {
        ItemStore itemStore = null;
        String sql = "SELECT item_id, item_type, item_name FROM items_store WHERE item_name = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemName);
            if(results.next()){
                itemStore = mapRowtoItemStore(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return itemStore;
    }


    @Override
    public List<ItemStore> getItemsByType(String itemType) {
        List<ItemStore> allItems  = new ArrayList<>();
        String sql = "SELECT * FROM items_store WHERE item_type = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, itemType);
        while(result.next()) {
            ItemStore item = mapRowtoItemStore(result);
            allItems.add(item);
        }
        return allItems;
    }



    private ItemStore mapRowtoItemStore(SqlRowSet rs){
        ItemStore itemStore = new ItemStore();
        itemStore.setItemId(rs.getInt("item_id"));
        itemStore.setItemType(rs.getString("item_type"));
        itemStore.setItemName(rs.getString("item_name"));
        return itemStore;
        }
}
