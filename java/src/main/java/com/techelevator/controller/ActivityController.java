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

//    @RequestMapping(path = "/activity/calculate-carrots/{kidId}", method = RequestMethod.PUT)
//    public void updateActivity (@RequestBody Activity activity, @PathVariable int kidId){
//        activityDao.updateActivity(activity);
//        int steps = activity.getSteps();
//        int minutes = activity.getMinutes();
//        int carrotsEarned = calculateCarrotsEarned(steps, minutes);
//
//        // Update play time and carrot balance in the database
//        Kid kid = kidDao.getKidById(kidId);
//        kid.setPlayTime(kid.getPlayTime() + carrotsEarned); // 1 sec play time for each carrot
//        kid.setCarrots(kid.getCarrots() + carrotsEarned);
//
//        kidDao.updateKid(kid);
//    }

    private int calculateCarrotsEarned(int steps, int minutes) {
        int totalActivity = steps + minutes;
        int carrotsEarned = totalActivity / 10; // 10 steps or 1 minute = 1 carrot
        return carrotsEarned;
    }

    @RequestMapping(path = "/activities/{userId}", method = RequestMethod.GET)
    public List<Activity> getActivitiesByUserId(@PathVariable int userId) {
        return activityDao.getActivitiesByUserId(userId);
    }

}
