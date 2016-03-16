package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.model.User;
import com.example.xiong.xionglearing.xcc.myeventbus.EventBus;


/**
 * Created by Administrator on 2016/2/18.
 */
public class EventBusReciveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recivie);
    }



    public void send(View s) {
        EventBus.postEvent("mybus",new User("xion",44));//created by xcc ，发现新版本,发送eventbus。
    }
}
