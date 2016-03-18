package com.example.xiong.xionglearing.xcc.ancitvity;

import android.content.Intent;
import android.view.View;

import com.example.xiong.xionglearing.R;

public class MainActivity extends BaseModelActivity {

    public void eventbus(View s) {
        startActivity(new Intent(this, EventBusActivity.class));
    }

    public void recyclerview(View s) {
        startActivity(new Intent(this, RecyclerviewActivity.class));
    }

    public void myTab(View s) {
        startActivity(new Intent(this, MytabActivity.class));
    }

    public void myMenu(View s) {
        startActivity(new Intent(this, MyMenuActivity.class));
    }

    public void mySelect(View s) {
        startActivity(new Intent(this, SelectActivity.class));
    }

    public void rank(View s) {
        startActivity(new Intent(this, RankViewActivity.class));
    }

    public void test(View s) {
        startActivity(new Intent(this, TestActivity.class));
    }

    public void autolayout(View s) {
        startActivity(new Intent(this, AutoLActivity.class));
    }

    public void lineView(View s) {
        startActivity(new Intent(this, LineViewActivity.class));
    }

    public void viewpager(View s) {
        startActivity(new Intent(this, PageTabActivity.class));
    }
    public void guaguaka(View s) {
        startActivity(new Intent(this, GuaGuaKaActivity.class));
    }
    public void viewJihe(View s) {
        startActivity(new Intent(this, SmallViewActivity.class));
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
