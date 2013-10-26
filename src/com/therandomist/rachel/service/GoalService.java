package com.therandomist.rachel.service;

import com.therandomist.rachel.R;
import com.therandomist.rachel.model.Goal;

import java.util.ArrayList;
import java.util.List;

public class GoalService {

    private static List<Goal> goalList;

    static {
        goalList = new ArrayList<Goal>();

        goalList.add(new Goal(1, "Butcher", "BUT", R.color.pale_purple));
        goalList.add(new Goal(2, "Baker", "BAK", R.color.blue));
        goalList.add(new Goal(3, "Candlestick Maker", "CAN", R.color.red));
        goalList.add(new Goal(4, "Photographer", "PHO", R.color.orange));
        goalList.add(new Goal(5, "Corresponder", "COR", R.color.beige));
        goalList.add(new Goal(6, "Coder", "COD", R.color.yellow));
        goalList.add(new Goal(7, "Designer", "DES", R.color.pale_green));
    }

    public List<Goal> getAllGoals(){
        return goalList;
    }

    public void deleteSelectedGoal(){

        List<Goal> removeList = new ArrayList<Goal>();

        for(Goal goal : goalList){
            if(goal.isSelected()){
                removeList.add(goal);
            }
        }

        for(Goal removeGoal : removeList){
            goalList.remove(removeGoal);
        }
    }

    public List<Goal> getTestGoals(int random){
        List<Goal> goals = new ArrayList<Goal>();
        switch(random){
            case(1):
                goals.add(goalList.get(0));
                break;
            case(2):
                goals.add(goalList.get(1));
                goals.add(goalList.get(3));
                break;
            case(3):
                goals.add(goalList.get(2));
                goals.add(goalList.get(4));
                goals.add(goalList.get(6));
                break;
        }
        return goals;
    }

}
