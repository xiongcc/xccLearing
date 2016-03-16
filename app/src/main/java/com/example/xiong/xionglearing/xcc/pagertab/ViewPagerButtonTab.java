package com.example.xiong.xionglearing.xcc.pagertab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;


/**
 * @author chengchangxiong
 * @date 2015/8/4
 * @time 11:27
 * @description
 */
public class ViewPagerButtonTab extends AbstractViewPagerTab {

    public ViewPagerButtonTab(Context context) {
        super(context);
    }

    public ViewPagerButtonTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPagerButtonTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 1.单实现一个接口，必须重写接口中的方法
     （如果接口的方法和Object中的方法一样例外）
     2.继承一个抽象类，必须重写抽象类中的抽象方法
     （如果抽象类中的方法和Object中的方法一样例外）
     3.继承了一个父类，当父类的方法无法满足子类需要时，
     重写从父类继承过来的方法
     */
    @Override
    protected void init(Context context) {
        //子类不满父类AbstractViewPagerTab方法，重写init方法，这时候，控件初始化的时候就会调用父类的init方法，接着调用子类的init方法
        super.init(context);
        setBackgroundColor( getResources().getColor(R.color.gray_tag_bg) );
        int padding = getResources().getDimensionPixelSize( R.dimen.dip14 );
        setPadding(padding, padding, padding, padding);
    }

    @Override
    protected void addTab(int index, int total, String tab) {
        Context context = getContext();
        TabText tabView = new TabText(context);
        tabView.setGravity(Gravity.CENTER);
        tabView.setText(tab);
        tabView.setOnClickListener(this);

        if ( total == 1 ) {
            tabView.setType( 1 );
        } else {
            if ( index == 0 ) {
                tabView.setType( 0 );
            } else if ( index == total - 1 ) {
                tabView.setType( 2 );
            } else {
                tabView.setType( 1 );
            }
        }

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        addView(tabView, lp);
    }

    /********************************************************************/

    private class TabText extends TextView implements TabIndicator{

        int type = 0;

        public TabText(Context context) {
            super(context);
            init( context );
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
            setTextSize(18);
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);

            Resources res = getContext().getResources();
            switch ( type ) {
                case 0:
                    setBackgroundDrawable(res.getDrawable(selected ? R.drawable.tab_l_on : R.drawable.tab_l));
                    break;
                case 1:
                    setBackgroundDrawable( res.getDrawable( selected ? R.drawable.tab_c_on : R.drawable.tab_c ) );
                    break;
                case 2:
                    setBackgroundDrawable( res.getDrawable( selected ? R.drawable.tab_r_on : R.drawable.tab_r ) );
                    break;
            }

            setTextColor( selected ? Color.WHITE : res.getColor( R.color.base_gray_tab ) );
        }

    }
}
