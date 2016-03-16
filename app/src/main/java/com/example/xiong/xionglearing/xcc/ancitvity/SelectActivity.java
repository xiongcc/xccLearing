package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.menu.CricleView;
import com.example.xiong.xionglearing.xcc.model.CricleInfo;

import java.util.ArrayList;


public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        CricleView cricle = (CricleView) findViewById(R.id.cricle_view);
        ArrayList<CricleInfo> list = new ArrayList<>();
        list.add(new CricleInfo(0,0,1));
        list.add(new CricleInfo(0,0,2));
        list.add(new CricleInfo(0,0,33));
        list.add(new CricleInfo(0,0,4));
        list.add(new CricleInfo(0,0,5));
        list.add(new CricleInfo(0,0,6));
        cricle.drawing(list);
        cricle.setOnCricleClickListener(new CricleView.OnCricleClick() {
            @Override
            public void onClick(int position) {
                Toast.makeText(SelectActivity.this,"positon="+position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
