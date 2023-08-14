package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.MascotSelection;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMascotSelectionDao implements MascotSelectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMascotSelectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MascotSelection> getAllMascotSelections() {
        List<MascotSelection> mascotSelections = new ArrayList<>();
        String sql = "SELECT * FROM mascot_selection";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                MascotSelection mascot = mapRowToMascotSelection(results);
                mascotSelections.add(mascot);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mascotSelections;
    }

    @Override
    public MascotSelection getMascotSelectionById(int mascotSelectionId) {
        MascotSelection mascot = null;
        String sql = "SELECT * FROM mascot_selection WHERE mascot_selection_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mascotSelectionId);
            if(results.next()){
                mascot = mapRowToMascotSelection(results);
            };
        } catch (Exception e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return mascot;
    }

//    @Override
//    public MascotSelection getMascotSelectionByImgURL(String imgURL) {
//        MascotSelection mascot = null;
//        String sql = "SELECT * FROM mascot_selection WHERE img_url = ?";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, imgURL);
//            if(results.next()){
//                mascot = mapRowToMascotSelection(results);
//            };
//        } catch (Exception e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return mascot;
//    }

    private MascotSelection mapRowToMascotSelection(SqlRowSet rs) {
        MascotSelection mascotSelection = new MascotSelection();
        mascotSelection.setMascotSelectionId(rs.getInt("mascot_selection_id"));
        mascotSelection.setImgURL(rs.getString("mascot_img_url"));
        return mascotSelection;
    }
}
