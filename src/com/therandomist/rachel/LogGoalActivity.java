package com.therandomist.rachel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LogGoalActivity extends BaseGoalListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_goal);
        adapter.setShowNameInBubble(true);

        FontSetter.setFont((TextView)findViewById(R.id.header), getAssets());
        FontSetter.setFont((TextView)findViewById(R.id.instruction), getAssets());

        Button dateButton = (Button)findViewById(R.id.date_button);
        if(dateButton != null){
            int identifier = getApplicationContext().getResources().getIdentifier("drawable/rounded_button", null, getApplicationContext().getPackageName());
            dateButton.setBackgroundResource(identifier);
            dateButton.setTextColor(getApplicationContext().getResources().getColor(R.color.white));
        }

    }
}
