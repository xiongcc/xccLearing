package com.example.xiong.xionglearing.xcc.ancitvity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/2/23.
 */
public abstract class BaseModelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        initData();
    }
    protected abstract int getLayoutID();
    protected abstract void initView();
    protected abstract void initData();

    protected void goActivity(Class activity){

        startActivity(new Intent(this,activity));
    }


}
