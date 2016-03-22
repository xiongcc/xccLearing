package com.example.xiong.xionglearing.xcc.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.model.CricleInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xcc on 2016/2/26.
 */
public class CricleView extends View implements View.OnClickListener{
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int MEARW;//view所给你的宽度
    private int MEARH;//view所给你的高度
    private int radius = 40;//圆的半径
    private int space = 10;//第一个圆到屏幕左边的距离
    private int textsize = 40;
    private boolean isDraw = false;
    private List<CricleInfo> list;
    int test = 9;

    public CricleView(Context context) {
        super(context);
    }

    public CricleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void drawing(ArrayList<CricleInfo> list) {
        this.list = list;
        paint.setAntiAlias(true);
        isDraw = true;
        postInvalidate();
        Log.e("tag",list.toString());
        this.setOnClickListener(this);
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
        if (!isDraw) return;
        for (int position = 0; position < list.size(); position++) {
            drawCricle(paint, false, false, Color.WHITE, getResources().getColor(R.color.cirlce), canvas, position);
        }
    }

    /**
     * @param paint
     * @param isStroke  是否空心
     * @param textColor 字体颜色
     * @param fillcolor 填充颜色
     * @param isDash    是否虚线
     * @param canvas
     * @param position  题号
     */
    protected void drawCricle(Paint paint, boolean isStroke, boolean isDash, int textColor, int fillcolor, Canvas canvas, int position) {
        /**
         * 计算每个圆的左右切点
         */
        float startX = space + (position) * (space + radius * 2);//根据等差数列的公式，圆心的左切点。
        float endX = (space + radius * 2) + (position) * ((space + radius * 2));//圆心的右切点。

        /**
         * 画圆弧
         */
        if (isDash) {
            PathEffect effect = new DashPathEffect(new float[]{8, 8, 8, 8}, 1);
            paint.setPathEffect(effect);
        }
        RectF oval = new RectF(startX, (float) MEARH / 2 - radius, endX, (float) MEARH / 2 + radius);
        paint.setColor(fillcolor);
        if (isStroke)
            paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(oval, 0, 360, false, paint);

        /**
         * 圆弧里的字
         */
        if (isDash) {
            PathEffect effect = new DashPathEffect(new float[]{0, 0, 0, 0}, 1);
            paint.setPathEffect(effect);
//            paint.reset();
        }
        paint.setColor(textColor);
        Rect rect = new Rect();
        paint.setTextSize(textsize);
        String text = list.get(position).getPosition() + "";
        paint.getTextBounds(text, 0, text.length(), rect);
        canvas.drawText(text, startX + radius - (float) rect.width() / 2, (MEARH / 2 + (float) rect.height() / 2), paint);//title

        /**
         * 存入每个圆的圆心
         */
        list.get(position).setCenterX(startX + radius);
        list.get(position).setCenterY((float) MEARH / 2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            for (int position = 0; position < list.size(); position++) {
                checkIsclude(x, y, list.get(position));
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

        }
        return true;
    }

    /**
     * @param upX
     * @param upY
     * @param info
     * @return 检验抬起的时候是否在圆心内
     */
    private boolean checkIsclude(float upX, float upY, CricleInfo info) {
        float x = (upX - info.getCenterX()) * (upX - info.getCenterX());
        float y = (upY - info.getCenterY()) * (upY - info.getCenterY());
        float result = (float) Math.sqrt(x + y);
        if (result > radius) {
        } else {
//            Log.v("Himi", "里面" + info.getPosition());
            click.onClick(info.getPosition());
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Log.e("tag","333333");
    }

    public interface OnCricleClick {
        void onClick(int position);
    }

    OnCricleClick click;

    public void setOnCricleClickListener(OnCricleClick click) {
        this.click = click;
    }
}