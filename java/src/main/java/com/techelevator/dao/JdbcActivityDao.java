package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Activity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcActivityDao implements ActivityDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcActivityDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Activity getActivityByKidId(int kidId) {
        Activity activity = null;
        String sql = "SELECT kids_id, steps, minutes FROM activity WHERE kids_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, kidId);
            if(results.next()){
                activity = mapRowToActivity(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return activity;
    }

    @Override
    public void updateActivity(Activity activity) {
        String sql = "UPDATE activity " +
                "SET minutes = ? " +
                "WHERE kids_id = ?;";
        jdbcTemplate.update(sql, activity.getMinutes(),activity.getSteps());
    }

    private Activity mapRowToActivity(SqlRowSet rs){
        Activity activity = new Activity();
        activity.setKidId(rs.getInt("kids_id"));
        activity.setSteps(rs.getInt("steps"));
        activity.setMinutes(rs.getInt("minutes"));
        return activity;
    }
}
