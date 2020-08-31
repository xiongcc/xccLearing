package com.example.xiong.xionglearing.xcc.ancitvity;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.myeventbus.EventBus;
import com.example.xiong.xionglearing.xcc.myeventbus.EventReceiver;


public class EventBusActivity extends BaseModelActivity {
//测试git提交1
    @Override
    protected int getLayoutID() {
        return R.layout.activity_event_bus;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        EventBus.registerReceiver(mReceiver);
    }

    private EventReceiver<Object> mReceiver = new EventReceiver<Object>() {
        @Override
        public void onEvent(String name, Object data) {
            if (name.equals("mybus")) {
                Log.e("EventReceiver", "name=" + name);
                Log.e("EventReceiver", data.toString());
            }
        }
    };

    public void recvice(View s) {
        startActivity(new Intent(this, EventBusReciveActivity.class));
    }
}
