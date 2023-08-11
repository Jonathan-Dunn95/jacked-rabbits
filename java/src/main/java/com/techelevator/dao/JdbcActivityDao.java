package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Activity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
                "SET steps = ?, minutes = ? " +
                "WHERE kids_id = ?;";
        jdbcTemplate.update(sql, activity.getSteps(), activity.getMinutes(), activity.getKidId());
    }

    @Override
    public List<Activity> getActivitiesByUserId(int userId) {
        List<Activity> activities = new ArrayList<>();
        String sql = "SELECT * FROM activity JOIN kids ON activity.kids_id = kids.kids_id WHERE kids.user_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                activities.add(mapRowToActivity(results));
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return activities;
    }

    private Activity mapRowToActivity(SqlRowSet rs){
        Activity activity = new Activity();
        activity.setKidId(rs.getInt("kids_id"));
        activity.setSteps(rs.getInt("steps"));
        activity.setMinutes(rs.getInt("minutes"));
        return activity;
    }
}
