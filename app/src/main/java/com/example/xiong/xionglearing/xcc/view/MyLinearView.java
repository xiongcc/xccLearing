package com.example.xiong.xionglearing.xcc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/3/16.
 */
public class MyLinearView extends View {
    private Path path = new Path();
    private Paint paint = new Paint();
    private boolean isComplete;
    private float startX;
    private float startY;
    private float moveToX;
    private float moveToY;
    {
        // 去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(236,236,236));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(16);
    }
    public MyLinearView(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    // 重写该方法，进行绘图
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isComplete) return;
        // 把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);

        if(startX == moveToX && startY == moveToY) {
            return;
        }
        path.moveTo(startX, startY);
        path.lineTo(moveToX, moveToY);
        canvas.drawPath(path, paint);
        startX = moveToX;
        startY = moveToY;
    }
    public void moveTo(float moveToX, float moveToY) {
        this.moveToX = moveToX;
        this.moveToY = moveToY;
    }
    public void startPosition(float startX, float startY) {
        this.startX = startX;
        this.startY = startY;
    }
    public void isComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
