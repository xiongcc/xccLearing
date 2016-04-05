package com.example.xiong.fuck.tag;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.xiong.fuck.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container,new BlankFragment()).commit();
    }
}
