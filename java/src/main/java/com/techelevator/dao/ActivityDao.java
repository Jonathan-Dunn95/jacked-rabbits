package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivityDao {

    Activity getActivityByKidId(int kidId);

    void updateActivity(Activity activity);

    List<Activity> getActivitiesByUserId(int userId);
}
