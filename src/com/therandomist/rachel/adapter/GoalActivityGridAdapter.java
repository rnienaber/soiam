package com.therandomist.rachel.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.therandomist.rachel.FontSetter;
import com.therandomist.rachel.R;
import com.therandomist.rachel.drawable.IamButton;
import com.therandomist.rachel.drawable.IamShape;
import com.therandomist.rachel.model.ActivityDay;
import com.therandomist.rachel.model.Goal;

import java.util.List;

public class GoalActivityGridAdapter extends ArrayAdapter<ActivityDay> {

    List<ActivityDay> days;

    public GoalActivityGridAdapter(Context context, int textViewResourceId, List<ActivityDay> days){
		super(context, textViewResourceId, days);
        this.days = days;
	}

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if(view == null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R.layout.calendar_cell, null);
		}

        TextView name = (TextView) view.findViewById(R.id.day_name);
		if(name != null){
			name.setText(days.get(position).getDay());
		}

        LinearLayout goalLayout = (LinearLayout) view.findViewById(R.id.goal_grid);
        goalLayout.removeAllViews();

        List<Goal> goals = days.get(position).getGoalList();

        if(goals != null){
            for(Goal goal : goals){
                Button button = new Button(getContext());
                button.setBackgroundDrawable(new IamShape(getContext().getResources().getColor(goal.getColor())));
                button.setText(goal.getShortCode());
                button.setTextSize(9);
                button.setTextColor(getContext().getResources().getColor(R.color.white));
                goalLayout.addView(button);
            }
        }
		return view;
	}
}
