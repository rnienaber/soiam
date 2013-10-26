package com.therandomist.rachel.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.therandomist.rachel.FontSetter;
import com.therandomist.rachel.R;
import com.therandomist.rachel.drawable.IamShape;
import com.therandomist.rachel.model.Goal;

import java.util.List;

public class GoalListAdapter extends ArrayAdapter<Goal>{

    List<Goal> goalList;
    AssetManager assetManager;
    boolean showNameInBubble;

    public GoalListAdapter(Context context, int textViewResourceId, List<Goal> goals, AssetManager assetManager){
		super(context, textViewResourceId, goals);
        this.goalList = goals;
        this.assetManager = assetManager;
	}

    public void setShowNameInBubble(boolean showNameInBubble) {
        this.showNameInBubble = showNameInBubble;
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if(view == null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R.layout.goal_list_row, null);
		}
		Goal goal = goalList.get(position);
		if(goal != null){
			layoutGoalRow(view, goal);
		}
		return view;
	}



    private void layoutGoalRow(View view, Goal goal){
		TextView name = (TextView) view.findViewById(R.id.goal_name);
        FontSetter.setFont(name, assetManager);
		if(name != null){
			name.setText(goal.getName());
		}

        Button codeButton = (Button) view.findViewById(R.id.goal_code);
		if(codeButton != null){
            codeButton.setBackgroundDrawable(new IamShape(getContext().getResources().getColor(goal.getColor())));
            if(showNameInBubble){
                codeButton.setText(goal.getName());
            }else{
                codeButton.setText(goal.getShortCode());
            }

		}

        if(goal.isSelected()){
            view.setBackgroundColor(getContext().getResources().getColor(R.color.nearly_black));
        }else{
            view.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        }
	}


}
