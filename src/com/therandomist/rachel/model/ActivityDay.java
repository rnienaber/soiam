package com.therandomist.rachel.model;

import java.util.Date;
import java.util.List;

public class ActivityDay {

    String day;
    List<Goal> goalList;

    public ActivityDay() {
    }

    public ActivityDay(String day) {
        this.day = day;
    }

    public ActivityDay(String day, List<Goal> goalList) {
        this.day = day;
        this.goalList = goalList;
    }

    public String getDay() {
        return day;
    }

    public void setGoalList(List<Goal> goalList) {
        this.goalList = goalList;
    }

    public List<Goal> getGoalList() {
        return goalList;
    }
}
