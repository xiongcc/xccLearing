package com.example.xiong.xionglearing.xcc.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xiong.xionglearing.R;

/**
 * 明显这种方式只适合在布局中定义的view，你要在程序运行起来的时候去改样式很难，
 * 所以这适合app所有的activity通用的返回样式
 * Created by Administrator on 2016/2/24.
 */
public class MySelectMenu extends LinearLayout {


    public MySelectMenu(Context context) {
        super(context);
        init(context);
    }

    public MySelectMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MySelectMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.select, this);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout);
        for (int i = 0; i < 5; i++) {
            View inf = LayoutInflater.from(context).inflate(R.layout.item_setlect, null);
            LinearLayout item_layout = (LinearLayout) inf.findViewById(R.id.item_layout);
            layout.addView(item_layout);
        }

//        layout.addView(item_layout);
//        if (layout.getParent() != null)
//            layout.removeAllViews();
//        layout.addView(item_layout);


    }

}
