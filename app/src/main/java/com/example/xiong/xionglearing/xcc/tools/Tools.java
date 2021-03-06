package com.example.xiong.xionglearing.xcc.tools;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/2/26.
 */
public class Tools {
    public static float dp2px(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * @param
     * @return
     */
    public static int getPhoneWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    public static int getPhoneHeigth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }


    /**
     * @param 返回某个控件在屏幕中的坐标，【0】为x
     * @return
     */
    public static int[] getViewScreenXY(View view){
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return location;
    }

}
