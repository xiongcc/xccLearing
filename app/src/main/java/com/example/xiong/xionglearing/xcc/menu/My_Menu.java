package com.example.xiong.xionglearing.xcc.menu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
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
public class My_Menu extends LinearLayout {
    public String[] msg = {"爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗", "爱我", "你怕", "了吗"};
    private SparseArray<View> sa = new SparseArray<>();
    private boolean isFrist;
    private MyMuen menu;

    public My_Menu(Context context) {
        super(context);
    }

    public My_Menu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public My_Menu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!isFrist)
            setView();
        isFrist = true;
    }

    void setView() {
        this.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams layout = getLayoutParams();
        layout.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layout.width = 200;
        boolean isSelect = false;
        for (int v = 0; v < msg.length; v++) {
            if (v == 0)
                isSelect = true;
            else
                isSelect = false;
            final View view = getChildLyout(msg[v], isSelect);
            sa.put(v, view);
            view.setTag(v);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int vv = 0; vv < sa.size(); vv++) {
                        sa.get(vv).setBackgroundColor(Color.WHITE);
                    }
                    sa.get((int) view.getTag()).setBackgroundColor(Color.GRAY);
                    menu.setOnMyMueuListener((int) view.getTag());
                }
            });
            this.addView(view);
        }
    }

    View getChildLyout(String text, boolean isSelect) {
        LinearLayout layout = new LinearLayout(this.getContext());
        layout.setGravity(Gravity.CENTER);
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 100);
        TextView tv = new TextView(this.getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setText(text);
        layout.addView(tv, params);
        if (isSelect) {
            layout.setBackgroundColor(Color.GRAY);
        }
        return layout;

    }

    public interface MyMuen {
        void setOnMyMueuListener(int tag);

    }

    public void setOnMyMueuListener(MyMuen menu) {
        this.menu = menu;

    }


}
