package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.menu.CustomTab;

public class MytabActivity extends AppCompatActivity {

    CustomTab tab;
    int tab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytab);
        tab = (CustomTab) findViewById(R.id.mytab);
        tab.setOnMyTabListener(new CustomTab.MyTab() {
            @Override
            public void setOnMyTabListener(int i) {
                Log.e("tag", "tag=" + i);
                Toast.makeText(MytabActivity.this, "当前页码=" + i, Toast.LENGTH_SHORT).show();
            }
        }, false);
    }

    public void go(View s) {
        tab.setTab(tab1);
        tab1++;
        if (tab1 == 3)
            tab1 = 0;
    }
}
