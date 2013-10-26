package com.therandomist.rachel.service;

import com.therandomist.rachel.model.GoalActivity;

import java.util.ArrayList;
import java.util.List;

public class GoalActivityService {

    private static List<GoalActivity> activityList = new ArrayList<GoalActivity>();

    public List<GoalActivity> getAllGoalActivities(){
        return activityList;
    }

    public void saveGoalActivity(GoalActivity goalActivity){
        activityList.add(goalActivity);
    }
}
