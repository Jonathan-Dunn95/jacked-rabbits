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

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemStoreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ItemStore getItemByItemId(int itemId) {
        ItemStore itemStore = null;
        String sql = "SELECT img_url FROM items_store WHERE item_id =?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
            if(results.next()){
                itemStore = mapRowToItemStore(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect server to Item Store database", e);
        }
        return itemStore;
    }

    public List<ItemStore> listAllStoreItems() {
        List<ItemStore> storeItems = new ArrayList<>();
        String sql = "SELECT item_id, img_url FROM items_store";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                ItemStore item = mapRowToItemStore(results);
                storeItems.add(item);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return storeItems;
    }


    private ItemStore mapRowToItemStore(SqlRowSet rs) {
        ItemStore itemStore = new ItemStore();
        itemStore.setItemId(rs.getInt("item_id"));
        itemStore.setImgURL(rs.getString("img_url"));
        return itemStore;
    }
}