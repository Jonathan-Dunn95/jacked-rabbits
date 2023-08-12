package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.MascotSelection;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "SELECT * FROM mascot_selection";
        List<MascotSelection> mascotSelections = new ArrayList<>();
        try {
            jdbcTemplate.query(sql, resultSet -> {
                MascotSelection mascotSelection = new MascotSelection();
                mascotSelection.setMascotSelectionId(resultSet.getInt("mascot_selection_id"));
                mascotSelection.setImgURL(resultSet.getString("img_url"));
                mascotSelections.add(mascotSelection);
            });
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return null;
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
}
