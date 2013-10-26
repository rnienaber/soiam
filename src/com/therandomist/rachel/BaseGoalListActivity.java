package com.therandomist.rachel;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.therandomist.rachel.adapter.GoalListAdapter;
import com.therandomist.rachel.model.Goal;
import com.therandomist.rachel.service.GoalService;

import java.util.List;

public class BaseGoalListActivity extends ListActivity{

    GoalService service = new GoalService();
    GoalListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new GoalListAdapter(this, R.layout.goal_list_row, service.getAllGoals(), getAssets());
        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Goal> goals = service.getAllGoals();
        for(Goal goal : goals){
            goal.setSelected(false);
        }

        adapter.notifyDataSetChanged();
    }
}
