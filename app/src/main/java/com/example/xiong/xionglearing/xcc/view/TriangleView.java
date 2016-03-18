package com.example.xiong.xionglearing.xcc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.xiong.xionglearing.R;

/**
 * 利用path‘画一个三角形指示器，就是下拉经常用的那个三角形
 */
public class TriangleView extends View implements View.OnClickListener{
    private Paint paint;
    private Path path;
    private int width;
    private int height;
    private onTriangleViewListtener mOnTriangleViewListener;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //这里得到的宽高的基准都是xml给与他的区域左上角为（0，0），而不是屏幕的左上角
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    public TriangleView(Context context) {
        super(context);
        init();
    }

    public TriangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int offsetW = width / 3;
        int offsetH = height/3;
        //画三角形
        path.moveTo(offsetW, offsetH);
        path.lineTo(offsetW*1.5f, offsetH*2);
        path.lineTo(offsetW*2, offsetH);

        canvas.drawPath(path, paint);
//        canvas.drawLine(0, linePaddingH, 0, height - linePaddingH, paint);
        this.setOnClickListener(this);
    }


    public void setTriangleCallBack(onTriangleViewListtener listener){
        this.mOnTriangleViewListener = listener;
    }

   public interface onTriangleViewListtener{

        void clickMe();
    }
    @Override
    public void onClick(View view) {
        mOnTriangleViewListener.clickMe();
    }

}
