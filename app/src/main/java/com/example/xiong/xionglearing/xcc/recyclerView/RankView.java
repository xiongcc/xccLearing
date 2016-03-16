package com.example.xiong.xionglearing.xcc.recyclerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.xiong.xionglearing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xcc on 2015-10-12
 */
public class RankView extends View {
    private Context context;
    private int RANKNUM;//柱状个数
    private int MEARW;//view所给你的宽度
    private int MEARH;//view所给你的高度
    private int OFFSET;//平均分后的每份的偏移量
    private List<String> tilte = new ArrayList<>();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float PERCENT = 0.01f;
    private int THREADTIME = 2500;
    private float TEXTSIZE;
    private float MARGINBOTTOM = 40;
    private float MARGINTOP = 30;
    private int ALLPERSONNNUM = 500;
    private int[] CircleColor = {
            R.color.circle_color_one,
            R.color.circle_color_two,
            R.color.circle_color_three,
            R.color.circle_color_four,
            R.color.circle_color_five,
    };
    private int MAX_TEXT_WIDTH;

    public void rankRun(List<String> tilte) {
        this.tilte = tilte;
        RANKNUM = tilte.size();
        OFFSET = MEARW / (5 + (RANKNUM * 4 - 4));//平均分后的每份的偏移量
        TEXTSIZE = dp2px(context, 10);
        MAX_TEXT_WIDTH = 3 * OFFSET;
        paint.setAntiAlias(true);
        refush();
    }
//    private int getColor(){
//
//        int random = (int) (Math.random()*5);
//
//
//    }



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                postInvalidate();
            }
        }
    };

    public void refush() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (PERCENT <= 1f) {
                    PERCENT += 0.01;
                    try {
                        Thread.sleep(THREADTIME / 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(1);
                }
            }
        }).start();
    }

    public RankView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.CylindricalNum);
//        RANKNUM = tArray.getInt(R.styleable.CylindricalNum_num, 0);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        MEARW = MeasureSpec.getSize(widthMeasureSpec);
        MEARH = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(MEARW, MEARH);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (OFFSET == 0) {
            RANKNUM = tilte.size();
            OFFSET = MEARW / (5 + (RANKNUM * 4 - 4));//平均分后的每份的偏移量
            TEXTSIZE = dp2px(context, 10);
            MAX_TEXT_WIDTH = (int) (3.5 * OFFSET);
        }
        Rect rect = new Rect();
        if (tilte != null && tilte.size() == 0) {
            if (tilte == null || tilte.size() == 0) {
                //没有数据的时候默认五个一样高的柱状体
                OFFSET = MEARW / (5 + (5 * 4 - 4));//平均分后的每份的偏移量
                MAX_TEXT_WIDTH = (int) (3.5 * OFFSET);
                paint.setColor(getResources().getColor(CircleColor[1]));
                for (int position = 0; position < 5; position++) {
                    paint.setColor(getResources().getColor(CircleColor[position % 5]));
                    float x = OFFSET + 4 * position * OFFSET;//每个柱状体左边离手机屏幕左边的距离
                    canvas.drawRect(x, MEARH - MARGINTOP - dp2px(context, 15), x + 3 * OFFSET, MEARH - MARGINBOTTOM, paint);
                    paint.setTextSize(TEXTSIZE);
                    paint.setColor(Color.BLACK);
                    String po = (position + 1) + "";
                    paint.getTextBounds(po, 0, po.length(), rect);
                    canvas.drawText(po + "", x + (3 * OFFSET - rect.width()) / 2f, MEARH - MARGINBOTTOM + rect.height() + 10, paint);//序列号
                    if (tilte.size() > 8)
                        paint.setTextSize(TEXTSIZE / 3 * 2);
                    else
                        paint.setTextSize(TEXTSIZE);
                    String strTitle = "无";
                    paint.getTextBounds(strTitle, 0, strTitle.length(), rect);
                    canvas.drawText(strTitle, x + (3 * OFFSET - rect.width()) / 2f, MEARH - MARGINTOP - dp2px(context, 15) - 10, paint);//title
                }
                canvas.drawLine(0, MEARH - MARGINBOTTOM, MEARW, MEARH - MARGINBOTTOM, paint);
                return;
            }
//            if (tilte.get(0).getPersonNum() <= 2)
//                ALLPERSONNNUM = 2 + tilte.get(0).getPersonNum();
//            else
//                ALLPERSONNNUM = tilte.get(0).getPersonNum() / 3 * 1 + tilte.get(0).getPersonNum();
            float averagePersonW = (float) MEARH / ALLPERSONNNUM * PERCENT;//高度除了人数等于每个人数的所占高度然后乘以所占比例，用于动画
            paint.setColor(Color.BLACK);
            paint.setAntiAlias(true);
            for (int position = 0; position < tilte.size(); position++) {
                paint.setColor(getResources().getColor(CircleColor[position % 5]));
                float x = OFFSET + 4 * position * OFFSET;//每个柱状体左边离手机屏幕左边的距离
                int personNum = 100;
                canvas.drawRect(x, MEARH - MARGINTOP - averagePersonW * personNum, x + 3 * OFFSET, MEARH - MARGINBOTTOM, paint);
                paint.setTextSize(TEXTSIZE);
                paint.setColor(Color.BLACK);
                String po = (position + 1) + "";
                paint.getTextBounds(po, 0, po.length(), rect);
                canvas.drawText(po + "", x + (3 * OFFSET - rect.width()) / 2f, MEARH - MARGINBOTTOM + rect.height() + 10, paint);//序列号
                if (tilte.size() > 8)
                    paint.setTextSize(TEXTSIZE / 3 * 2);
                else
                    paint.setTextSize(TEXTSIZE);
                String strTitle = "ddd";
                int breakText = paint.breakText(strTitle, true, MAX_TEXT_WIDTH, null);
                if (breakText < strTitle.length()) {
                    strTitle = strTitle.substring(0, breakText) + "...";
                }
                paint.getTextBounds(strTitle, 0, strTitle.length(), rect);
                canvas.drawText(strTitle, x + (3 * OFFSET - rect.width()) / 2f, MEARH - MARGINTOP - averagePersonW * personNum - 10, paint);//title
                if (rect.height() <= -MARGINBOTTOM + MARGINTOP + averagePersonW * personNum - 10) {
                    //如果柱状体的高度太小，则不画text，否则画
                    String strPersonNum = personNum + "人";
                    paint.getTextBounds(strPersonNum, 0, strPersonNum.length(), rect);
                    canvas.drawText(strPersonNum, x + (3 * OFFSET - rect.width()) / 2f, MEARH - MARGINTOP - averagePersonW * personNum + rect.height() + 10, paint);//人数
                }
            }
            canvas.drawLine(0, MEARH - MARGINBOTTOM, MEARW, MEARH - MARGINBOTTOM, paint);
        }
    }
    public float dp2px(Context context, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
