package com.example.xiong.xionglearing.xcc.tools;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * @author DavidDing
 * @date 2015/6/24
 * @time 10:54
 * @description
 */
public class ScreenUitls {

    private ScreenUitls() {}

    public static float dp2px(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static DisplayMetrics getMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float getDensity(Context context) {
        return getMetrics( context ).density;
    }

    public static float getScaleDensity(Context context) {
        return getMetrics( context ).scaledDensity;
    }

    public static int getScreenWidth(Context context) {
        return getMetrics( context ).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return getMetrics( context ).heightPixels;
    }

}
