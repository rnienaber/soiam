package com.therandomist.rachel.drawable;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

public class IamShape extends ShapeDrawable{

    private static final float[] roundedCorner = new float[] { 4, 4, 4, 4, 4, 4, 4, 4 };
    private static final float[] innerRoundedCorner = new float[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    private static final RectF inset = new RectF(0, 0, 0, 0);

    public IamShape(int color) {
        super(new RoundRectShape(roundedCorner, inset, innerRoundedCorner));

        setPadding(3, 3, 3, 3);
        getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        getPaint().setColor(color);
    }
}

/*//            StateListDrawable states = new StateListDrawable();

            float[] roundedCorner = new float[] { 4, 4, 4, 4, 4, 4, 4, 4 };
            float[] innerRoundedCorner = new float[] { 0, 0, 0, 0, 0, 0, 0, 0 };
            RectF inset = new RectF(0, 0, 0, 0);

            RoundRectShape round = new RoundRectShape(roundedCorner, inset, innerRoundedCorner);

            ShapeDrawable shape = new ShapeDrawable(round);
            shape.setPadding(3,3,3,3);
            shape.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            shape.getPaint().setColor(Color.MAGENTA);

//            states.addState(new int[] {}, shape);*/
