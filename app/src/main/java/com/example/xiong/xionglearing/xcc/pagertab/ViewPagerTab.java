package com.example.xiong.xionglearing.xcc.pagertab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.tools.ScreenUitls;


/**
 * @author chengchangxiong
 * @date 2015/7/21
 * @time 18:04
 * @description
 */
public class ViewPagerTab extends AbstractViewPagerTab {

    protected int mSingleTabWidth;

    private int mTitleColor = Color.WHITE;
    private int mTitleColorSelected = Color.WHITE;

    private int mIndicatorColor = Color.WHITE;

    public ViewPagerTab(Context context) {
        super(context);
    }

    public ViewPagerTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPagerTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void init(Context context) {
        super.init(context);
        Log.e("tag", "ViewPagerTab==>init");
        Resources res = getResources();
        mIndicatorColor = res.getColor(R.color.sw_bg_bar_on_color);
        mTitleColor = res.getColor(R.color.text_color_tab_normal);
        mTitleColorSelected = Color.WHITE;
    }

    @Override
    protected void addTab(int index, int total, String tab) {
        Log.e("tag","ViewPagerTab==>bind");
        Context context = getContext();
        TextView textView = new TabText(context);
        textView.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp;

        if (mSingleTabWidth > 0) {
            lp = new LinearLayout.LayoutParams(mSingleTabWidth, LayoutParams.MATCH_PARENT);
        } else {
            lp = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);
            lp.weight = 1;
        }

        textView.setText(tab);
        textView.setTextColor(mTitleColor);
        addView(textView, lp);
        textView.setOnClickListener(this);
    }

    public void setSingleTabWidth(int width) {
        this.mSingleTabWidth = width;
    }

    public void setTitleColor(int color) {
        this.mTitleColor = color;
    }

    public void setTitleColorSelected(int color) {
        this.mTitleColorSelected = color;
    }

    public void setIndicatorColor(int color) {
        this.mIndicatorColor = color;
    }

    public void markTitle(String title, boolean marked) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof TabText) {
                TabText tab = (TabText) getChildAt(i);
                if (tab.getText().equals(title)) {
                    tab.mark(marked);
                    tab.invalidate();
                }
            }
        }
    }

    /********************************************************************/

    private class TabText extends TextView implements TabIndicator {

        private Paint paint;

        private Paint markPaint;

        private boolean marked = false;

        private int indicatorHeight = 0;
        private Context mContext;

        public TabText(Context context) {
            super(context);
            init(context);
        }

        public TabText(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public TabText(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            paint = new Paint();
            paint.setColor(mIndicatorColor);
            this.mContext = context;
            markPaint = new Paint();
            markPaint.setColor(Color.RED);

            indicatorHeight = (int) ScreenUitls.dp2px(context, 3);

            setTextColor(mTitleColor);
            setTextSize(18);
        }

        public void mark(boolean mark) {
            marked = mark;
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);
            setTextColor(selected ? mTitleColorSelected : mTitleColor);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            final int width = getMeasuredWidth();
            final int height = getMeasuredHeight();
Log.e("tag","height="+height);
            if (isSelected()) {
                canvas.save();
                canvas.drawRect(0, height - indicatorHeight, width, height, paint);
                //drawRect参数分别为左上右下，其实就是矩形区域左上角和右下角坐标
                canvas.restore();
            }

//            if (marked) {
//                canvas.save();
//                canvas.translate((int) (width * 0.8f), (int) (height * 0.2f));
//                canvas.drawCircle( 0, 0, 10, markPaint );
//                canvas.translate((int) (width * 0.8f), 0);//xcc,修改小红点显示位置
//                canvas.drawCircle(0, this.getHeight() / 2, (int) ScreenUitls.dp2px(mContext, 4), markPaint);
//                canvas.restore();
//            }
        }
    }

}
