package com.therandomist.rachel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.therandomist.rachel.model.Goal;

import java.util.List;

public class ManageGoalsActivity extends BaseGoalListActivity{

    Button addButton, editButton, deleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_goals);

        FontSetter.setFont((TextView)findViewById(R.id.header), getAssets());
        FontSetter.setFont((TextView)findViewById(R.id.instruction), getAssets());

        addButton = (Button)findViewById(R.id.add_goal_button);
        editButton = (Button)findViewById(R.id.edit_goal_button);
        deleteButton = (Button)findViewById(R.id.delete_goal_button);

        addListeners();
    }

    private void addListeners(){
        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                service.deleteSelectedGoal();
                toggleButtons(View.INVISIBLE);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);    //To change body of overridden methods use File | Settings | File Templates.

        List<Goal> goals = service.getAllGoals();

        for(int i=0; i< goals.size(); i++){
            Goal goal = goals.get(i);
            if(i == position){
                goal.setSelected(!goal.isSelected());
            }else{
                goal.setSelected(false);
            }
        }

        adapter.notifyDataSetChanged();

        if(goals.get(position).isSelected()){
            toggleButtons(View.VISIBLE);
        }else{
            toggleButtons(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        toggleButtons(View.INVISIBLE);
    }

    private void toggleButtons(int visibility){
        if(editButton != null)
            editButton.setVisibility(visibility);
        if(deleteButton != null)
            deleteButton.setVisibility(visibility);
    }
}
