package com.techelevator.dao;

import com.techelevator.model.Activity;

public interface ActivityDao {

    Activity getActivityByKidId(int kidId);

    void updateActivity(Activity activity);
}
