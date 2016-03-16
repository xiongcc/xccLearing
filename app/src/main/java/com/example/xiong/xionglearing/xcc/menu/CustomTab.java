package com.example.xiong.xionglearing.xcc.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by xcc on 2015/9/17.自定义tab导航栏
 */
public class CustomTab extends LinearLayout {
    private SparseArray<View> sa = new SparseArray<>();
    private int childCount;
    private MyTab tab;
    private int lastTag = 0;
    private boolean isTrue = false;
    private boolean isFrist;

    public CustomTab(Context context) {
        super(context);
    }

    public CustomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!isFrist)
            initLayout();
        isFrist = true;
    }

    private void initLayout() {
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER);

        ViewGroup.LayoutParams layoutParams1 = getLayoutParams();
        layoutParams1.width = LayoutParams.MATCH_PARENT;
        childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View childAt = getChildAt(i);
            childAt.setTag(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.weight = 1;
            childAt.setLayoutParams(layoutParams);
            if (i == 0)
                childAt.setSelected(true);
            sa.put(i, childAt);
            childAt.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) childAt.getTag();
                    if (!isTrue) {
                        if (lastTag == tag)
                            return;
                    }
                    for (int j = 0; j < childCount; j++) {
                        sa.get(j).setSelected(false);
                    }
                    View view = sa.get(tag);
                    view.setSelected(true);
                    tab.setOnMyTabListener(tag);
                    lastTag = tag;
                }
            });
        }
    }

    public interface MyTab {
        void setOnMyTabListener(int tag);
    }

    public void setOnMyTabListener(MyTab tab, boolean isSameTabEffect) {
        this.isTrue = isSameTabEffect;
        this.tab = tab;
    }

    public void setTab(int tab) {
        for (int i = 0; i < childCount; i++) {
            sa.get(i).setSelected(false);
            if (tab == i) {
                sa.get(tab).setSelected(true);
            }
        }
    }
}
