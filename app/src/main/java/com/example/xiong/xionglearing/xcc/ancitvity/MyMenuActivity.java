package com.example.xiong.xionglearing.xcc.ancitvity;

import android.widget.Toast;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.menu.My_Menu;

public class MyMenuActivity extends BaseModelActivity {


    @Override
    protected int getLayoutID() {
        return R.layout.activity_my_menu;
    }

    @Override
    protected void initView() {
        My_Menu menu = (My_Menu) findViewById(R.id.mymenu);

        menu.setOnMyMueuListener(new My_Menu.MyMuen() {
            @Override
            public void setOnMyMueuListener(int tag) {
                Toast.makeText(MyMenuActivity.this, "当前页码=" + tag, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
