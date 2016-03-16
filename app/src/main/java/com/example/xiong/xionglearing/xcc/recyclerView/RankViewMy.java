package com.example.xiong.xionglearing.xcc.recyclerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.xiong.xionglearing.R;

/**
 * Created by xcc on 2016/2/24.
 */
public class RankViewMy extends View {

    private int heigth;
    private int width;
    private float rankOffset;
    private int rankNum = 10;
    private float PERCENT = 0.01f;
    private int THREADTIME = 2500;
    private int rankHeigth = 150;
    private int marginBottom = 50;
    private int textsize = 20;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RankViewMy(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void rankRun() {
        paint.setAntiAlias(true);
        refush();
        Log.e("tag", "width=");
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1)
                postInvalidate();
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


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        heigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, heigth);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rankOffset = width / (float) (5 + ((rankNum) * 4 - 4));
        float rankHeigh = rankHeigth * PERCENT;//显示动画用的上升高度（柱状图高度）
        Rect rect = new Rect();
//        Log.e("tag","distance="+distance);
        for (int i = 0; i < rankNum; i++) {
            /**
             * 柱状图
             */
            paint.setColor(getResources().getColor(R.color.circle_color_three));
            float x = rankOffset + i * 4 * rankOffset ;
            canvas.drawRect(x, heigth - rankHeigh - marginBottom, x + 3 * rankOffset, heigth - marginBottom, paint);

            /**
             * 序列号
             */
            paint.setTextSize(textsize);
            paint.setColor(Color.BLACK);
            String position = "8";
            paint.getTextBounds(position, 0, position.length(), rect);
            canvas.drawText(position, x + (3 * rankOffset - rect.width()) / 2f, heigth - marginBottom + rect.height() + 10, paint);

            /**
             * 提示信息
             */
            String strTitle = "无";
            paint.getTextBounds(strTitle, 0, strTitle.length(), rect);
            canvas.drawText(strTitle, x + (3 * rankOffset - rect.width()) / 2f, heigth - rankHeigh - marginBottom - 10, paint);//title

            /**
             * 直线
             */
//            paint.setStrokeWidth((float) 3.0);              //设置线宽
            canvas.drawLine(0, heigth - marginBottom, width, heigth - marginBottom, paint);
        }
    }

    /**
     * x柱状图左边距离手机屏幕的距离
     * moveX柱状图这次需要移动的位置
     * lastMoveX记录上一次柱状图移动的位置
     */
//    float lastX = 0;
//    float downX = 0;
//    float moveX = 0;
//    float lastMoveX = 0;
//float distance = 0;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            downX = event.getX();
//        } else if (event.getAction() == MotionEvent.ACTION_UP) {
//            lastMoveX = moveX;
//            lastX = 0;
//        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
//            if (lastX != 0) {
//                moveX = event.getX() - downX + lastMoveX;
////                Log.e("tag", "firstX=" + firstX + "  rankOffset=" + rankOffset);
//
//
//                float vectorX =    event.getX() - lastX;
////                Log.e("tag","moveX="+moveX +"Math.abs(distance)="+Math.abs(distance)+"  vectorX="+vectorX);
//
////            if(vectorX>0){
////                //向右移动
////                if(moveX>=0){
////                    return true;
////                }
////            }
////
////            if(vectorX<0){
////                //向左移动
////                if(Math.abs(moveX)>=Math.abs(distance)){
////                    Log.e("tag","moveX=");
////                    return true;
////                }
////            }
//
//                postInvalidate();
//
//
//            }
//            lastX = event.getX();
//        }
//
//        return true;
//    }
}
