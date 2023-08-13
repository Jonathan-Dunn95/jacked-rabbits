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
        String sql = "SELECT * FROM mascot_selection WHERE mascot_selection_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{mascotSelectionId}, (resultSet, rowNum) -> {
                MascotSelection mascotSelection = new MascotSelection();
                mascotSelection.setMascotSelectionId(resultSet.getInt("mascot_selection_id"));
                mascotSelection.setImgURL(resultSet.getString("img_url"));
                return mascotSelection;
            });
        } catch (Exception e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    @Override
    public MascotSelection getMascotSelectionByImgURL(String imgURL) {
        String sql = "SELECT * FROM mascot_selection WHERE img_url = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{imgURL}, (resultSet, rowNum) -> {
                MascotSelection mascotSelection = new MascotSelection();
                mascotSelection.setMascotSelectionId(resultSet.getInt("mascot_selection_id"));
                mascotSelection.setImgURL(resultSet.getString("img_url"));
                return mascotSelection;
            });
        } catch (Exception e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
    }

    private MascotSelection mapRowToMascotSelection(SqlRowSet rs) {
        MascotSelection mascotSelection = new MascotSelection();
        mascotSelection.setImgURL(rs.getString("img_url"));
        mascotSelection.setMascotSelectionId(rs.getInt("item_id"));
        return mascotSelection;
    }
}
