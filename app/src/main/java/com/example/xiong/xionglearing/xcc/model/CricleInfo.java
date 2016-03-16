package com.example.xiong.xionglearing.xcc.model;

/**
 * Created by Administrator on 2016/2/26.
 */
public class CricleInfo {
    public float centerX;
    public float centerY;
    public int position;

    public CricleInfo(float centerX, float centerY, int position) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.position = position;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
