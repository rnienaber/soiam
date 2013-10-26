package com.therandomist.rachel;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

public class FontSetter {

    private static Typeface curlyFont = null;

    public static void setFont(TextView textView, AssetManager assetManager){
        if(textView != null){
            textView.setTypeface(getCurlyFont(assetManager));
        }
    }

    public static Typeface getCurlyFont(AssetManager assetManager) {
        if(curlyFont == null){
            curlyFont = Typeface.createFromAsset(assetManager, "alkisah.ttf");
        }
        return curlyFont;
    }
}
