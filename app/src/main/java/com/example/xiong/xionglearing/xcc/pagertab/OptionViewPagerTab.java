package com.example.xiong.xionglearing.xcc.pagertab;/**
 * Created by cpoopc on 2015/7/28.
 */

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.tools.ScreenUitls;


/**
 * User: chengchangxiong
 * Date: 2015-07-28
 * Time: 15:35
 * Ver.: 0.1
 */
public class OptionViewPagerTab extends ViewPagerTab {

    private int mMarginTB;
    private int mMarginLR;
    private int mPadding;
    private int targetX;

    public OptionViewPagerTab(Context context) {
        super(context);
        init();
    }

    public OptionViewPagerTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OptionViewPagerTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mMarginTB = (int) ScreenUitls.dp2px(getContext(), 10);
        mMarginLR = (int) ScreenUitls.dp2px(getContext(), 8);
        mPadding = (int) ScreenUitls.dp2px(getContext(), 10);
    }

    @Override
    protected void addTab(int index, int total, String tab) {
        Context context = getContext();
        OptionTabIndicator view = new OptionTabIndicator(context);
        view.setGravity( Gravity.CENTER );
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.leftMargin = mMarginLR;
        lp.rightMargin = mMarginLR;
        lp.topMargin = mMarginTB;
        lp.bottomMargin = mMarginTB;
//        view.setPadding(mPadding,0,mPadding,0);
        view.setText(tab);
        addView(view, lp);
        view.setOnClickListener(this);

    }

    private class OptionTabIndicator extends RelativeLayout implements TabIndicator {


        private int mColorSelected = 0;
        private int mColorUnSelected = 0;
        private TextView textView;

        private RelativeLayout container;


        public OptionTabIndicator(Context context) {
            super(context);
            init(context);
        }

        public OptionTabIndicator(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public OptionTabIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            container = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.option_pager_tab_view, this, true);
            textView = (TextView) container.findViewById(R.id.title_tv);
            mColorSelected = getResources().getColor(R.color.tag_custom_text_color);
            mColorUnSelected = getResources().getColor(R.color.text_color_second);
            textView.setTextColor(mColorUnSelected);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);
            textView.setTextColor(selected ? mColorSelected : mColorUnSelected);
//            if (selected) {
//                container.setBackgroundResource(R.drawable.common_tag_checked_background);
//            } else {
//                container.setBackgroundResource(R.drawable.common_tag_normal_background);
//            }
        }

        public void setText(CharSequence text) {
            textView.setText(text);
        }

        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            if (isSelected()) {
                targetX = getTargetX(this);
                if (onSeletedCallBack != null) {
                    onSeletedCallBack.onSelect(targetX);
                }
            }
        }
    }

    private int getTargetX(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
//            DebugLog.e("TargetX:"+rect.left + " rect: " + rect);
            return rect.left;
        }
        return -1;
    }

    private OnSeletedCallBack onSeletedCallBack;

    public void setOnSeletedCallBack(OnSeletedCallBack onSeletedCallBack) {
        this.onSeletedCallBack = onSeletedCallBack;
    }

    public interface OnSeletedCallBack{
        void onSelect(int targetX);
    }

}
