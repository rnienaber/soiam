package com.therandomist.rachel.drawable;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.therandomist.rachel.R;
import com.therandomist.rachel.model.Goal;

public class IamButton extends Button {

	private Goal goal;

	public IamButton(Context context, Goal goal) {
		super(context);
		this.goal = goal;

		setText(goal.getShortCode());
		setTypeface(Typeface.DEFAULT, Typeface.BOLD);

		int identifier = 0;

        identifier = getContext().getResources().getIdentifier("drawable/rounded_button", null, getContext().getPackageName());
        setTextColor(getContext().getResources().getColor(R.color.white));

		setBackgroundResource(identifier);
	}
}
