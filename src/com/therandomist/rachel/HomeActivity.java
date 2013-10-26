package com.therandomist.rachel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.therandomist.rachel.adapter.GoalActivityGridAdapter;
import com.therandomist.rachel.model.ActivityDay;
import com.therandomist.rachel.model.Goal;
import com.therandomist.rachel.service.GoalService;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity {

    GoalService goalService = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        goalService = new GoalService();

        FontSetter.setFont((TextView)findViewById(R.id.header), getAssets());
        FontSetter.setFont((TextView)findViewById(R.id.app_blurb_1), getAssets());
        FontSetter.setFont((TextView)findViewById(R.id.app_blurb_2), getAssets());
        FontSetter.setFont((TextView)findViewById(R.id.this_week), getAssets());

        Button manageButton = (Button) findViewById(R.id.manage_goals);
		manageButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				Intent i = new Intent(view.getContext(), ManageGoalsActivity.class);
				startActivity(i);
			}
		});

        Button logActivityButton = (Button) findViewById(R.id.log_activity);
		logActivityButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				Intent i = new Intent(view.getContext(), LogGoalActivity.class);
				startActivity(i);
			}
		});

        layoutWeek();
    }

    @Override
    protected void onResume() {
        super.onResume();
        layoutWeek();
    }

    private void layoutWeek(){

        List<ActivityDay> days = new ArrayList<ActivityDay>();
        days.add(new ActivityDay("SUN"));
        days.add(new ActivityDay("MON"));
        days.add(new ActivityDay("TUE"));
        days.add(new ActivityDay("WED"));
        days.add(new ActivityDay("THU"));
        days.add(new ActivityDay("FRI"));
        days.add(new ActivityDay("SAT"));

        days.get(0).setGoalList(goalService.getTestGoals(1));
        days.get(2).setGoalList(goalService.getTestGoals(2));
        days.get(3).setGoalList(goalService.getTestGoals(3));
        days.get(6).setGoalList(goalService.getTestGoals(2));

        GoalActivityGridAdapter adapter = new GoalActivityGridAdapter(getApplicationContext(), R.layout.calendar_cell, days);
        GridView calendar = (GridView)findViewById(R.id.week_grid);
        calendar.setAdapter(adapter);
    }
}
