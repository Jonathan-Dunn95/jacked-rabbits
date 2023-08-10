package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ActivityController {
    private ActivityDao activityDao;

    public ActivityController(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @RequestMapping(path = "/activity/{kidId}", method = RequestMethod.GET)
    public Activity getActivityByKidId(@PathVariable int kidId) {
        return activityDao.getActivityByKidId(kidId);
    }

    @RequestMapping(path = "/activity/update/{kidId}", method = RequestMethod.PUT)
    public void updateActivity (@RequestBody Activity activity){
        this.activityDao.updateActivity(activity);
    }

}
