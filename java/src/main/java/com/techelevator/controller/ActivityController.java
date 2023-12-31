package com.techelevator.controller;

import com.techelevator.dao.ActivityDao;
import com.techelevator.dao.KidDao;
import com.techelevator.model.Activity;
import com.techelevator.model.ActivityDto;
import com.techelevator.model.Kid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {
    private ActivityDao activityDao;

    private KidDao kidDao;

    @Autowired
    public ActivityController(ActivityDao activityDao, KidDao kidDao) {
        this.activityDao = activityDao;
        this.kidDao = kidDao;
    }

    @RequestMapping(path = "/activity/{kidId}", method = RequestMethod.GET)
    public Activity getActivityByKidId(@PathVariable int kidId) {
        return activityDao.getActivityByKidId(kidId);
    }

    @RequestMapping(path = "/activity/update/{kidId}", method = RequestMethod.PUT)
    public void updateActivity (@RequestBody Activity activity, @PathVariable int kidId){

        int steps = activity.getSteps();
        int minutes = activity.getMinutes();
        Activity currentActivity = activityDao.getActivityByKidId(kidId);
        int carrotsEarned = minutes-currentActivity.getMinutes();
        int playTimeEarned = (steps-currentActivity.getSteps())/10;


        // Update play time and carrot balance in the database
        Kid kid = kidDao.getKidById(kidId);
        kid.setPlayTime(kid.getPlayTime() + playTimeEarned);
        kid.setCarrots(kid.getCarrots() + carrotsEarned);
        activityDao.updateActivity(activity);
        kidDao.updateKid(kid);
    }

//    private int calculateCarrotsEarned(int steps, int minutes) {
//        int totalActivity = steps + minutes;
//        int carrotsEarned = totalActivity / 10; // 10 steps or 1 minute = 1 carrot
//        return carrotsEarned;
//    }


    @RequestMapping(path = "/activities/{userId}", method = RequestMethod.GET)
    public List<Activity> getActivitiesByUserId(@PathVariable int userId) {
        return activityDao.getActivitiesByUserId(userId);
    }

}
