package com.example.xiong.xionglearing.xcc.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.xiong.xionglearing.R;

public class test1 extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        img = (ImageView) findViewById(R.id.imageView);



    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

//        img.setImageResource(R.drawable.ttt);
//        img.setBackgroundResource(R.drawable.ttt);
    }
}
