package com.example.xiong.xionglearing.xcc.pagertab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/**
 * @author chengchangxiong
 * @date 2015/8/4
 * @time 11:13
 * @description
 */
public abstract class AbstractViewPagerTab extends LinearLayout implements View.OnClickListener {

    private int mCurrentIndex = 0;

    private OnTabSelectedListener mTabSelectedListener;

    public AbstractViewPagerTab(Context context) {
        super(context);
        init(context);
    }

    public AbstractViewPagerTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AbstractViewPagerTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context) {
        Log.e("tag","AbstractViewPagerTab==>init");
        setOrientation(HORIZONTAL);
    }


    public void setTabSelectedListener(OnTabSelectedListener listener) {
        this.mTabSelectedListener = listener;
    }

    public void bindPager(final ViewPager pager) {
        pager.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bind(pager);
                pager.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void bind(ViewPager pager) {
        if ( pager == null || pager.getAdapter() == null ) return;
        PagerAdapter adapter = pager.getAdapter();
        removeAllViews();

        for (int i = 0; i < adapter.getCount(); i++) {
            //这里得到viewapger里面getPageTitle返回的字符串，用于tab显示
            String text = adapter.getPageTitle(i).toString();
            Log.e("tag","AbstractViewPagerTab==>bind");
            /**
             * 在這調用了addTab抽象方法，这就调用了子类ViewpagerTab里的addTab的方法
             */
            addTab( i, adapter.getCount(), text);
        }

        setCurrentTab(pager.getCurrentItem());
    }

    protected abstract void addTab(int index, int total, String tab);


    @Override
    public void onClick(View v) {
        if ( v instanceof TabIndicator ) {
            toggleTabClick((TabIndicator)v);
        }
    }

    public void setCurrentTab(int index) {
        mCurrentIndex = index;
        for ( int i = 0; i < getChildCount(); i++ ) {
            View v = getChildAt(i);
            if ( v instanceof TabIndicator ) {
                //子类ViewPagerTab继承了TabIndicator，所以就属于TabIndicator，所以v instanceof TabIndicator成立
                v.setSelected( i == index );
            }
        }
    }

    private void toggleTabClick(TabIndicator tab) {
        for ( int i = 0; i < getChildCount(); i++ ) {
            View v = getChildAt(i);
            if ( v instanceof TabIndicator ) {
                if ( v == tab ) {
                    v.setSelected( true );
                    if ( mTabSelectedListener != null ) {
                        mTabSelectedListener.onTabSelected( i );
                    }
                } else {
                    v.setSelected( false );
                }

            }
        }
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

}
