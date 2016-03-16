package com.example.xiong.xionglearing.xcc.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/15.
 */
public class MyHome extends View {
    public MyHome(Context context) {
        super(context);
    }

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int MEARW;//view所给你的宽度
    private int MEARH;//view所给你的高度
    private float cricleY;
    private float cricleX;
    private int CricleWai = 50;
    private int CricleNei = 30;
    private int space = 10;//第一个圆到屏幕左边的距离
    private ArrayList<CricleInfo> list = new ArrayList<>();

    public MyHome(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        init();

    }

    void init() {

        cricleY = MEARH / 2f;
        cricleX = MEARH / 2f;
        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 0:
                    CricleInfo info0 = new CricleInfo(cricleX, cricleY);
                    list.add(info0);
                    break;
                case 1:
                    CricleInfo info1 = new CricleInfo(cricleX + CricleWai / 2f, cricleY * 2f);
                    list.add(info1);
                    break;
                case 2:
                    CricleInfo info2 = new CricleInfo(cricleX - CricleNei, cricleY * 3f);
                    list.add(info2);
                    break;
                case 3:
                    CricleInfo info3 = new CricleInfo(cricleX + CricleNei / 2f, cricleY * 4f);
                    list.add(info3);
                    break;
            }

        }


//        RectF oval = new RectF(startX, (float) MEARH / 2 - radius, endX, (float) MEARH / 2 + radius);



    }

    void drawCricle() {


    }


    class CricleInfo {
        float x;
        float y;

        public CricleInfo(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

}
