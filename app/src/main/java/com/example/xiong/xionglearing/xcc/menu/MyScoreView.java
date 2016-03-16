package com.example.xiong.xionglearing.xcc.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 竖向类似listview的点击菜单
 * Created by xiongcc on 2016/1/26.
 */
public class MyScoreView extends LinearLayout {
    private SparseArray<View> sa = new SparseArray<>();
    private boolean isFrist;

    public MyScoreView(Context context) {
        super(context);
    }

    public MyScoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void refush(){

        String[]   msg = new String[]{"爱我", "你怕", "了吗", "爱我", "你怕","你怕","你怕","爱我", "爱我",};
        isFrist = false;
        sa.clear();
        setView(msg);
//        isFrist = true;

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.e("tag", "onLayout");
//        if (!isFrist)
//            setView();
//        isFrist = true;
    }

    void setView(String[]   msg) {
        this.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams layout = getLayoutParams();
        layout.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layout.width = ViewGroup.LayoutParams.MATCH_PARENT;
        for (int v = 0; v < msg.length; v++) {
            final View view = getChildLyout(msg[v]);
            sa.put(v, view);
            view.setTag(v);
            this.addView(view);
        }
    }

    View getChildLyout(String text) {
        LinearLayout layout = new LinearLayout(this.getContext());
        layout.setGravity(Gravity.CENTER);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 100);
        TextView tv = new TextView(this.getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setText(text);
        layout.addView(tv, params);
        return layout;

    }



}
