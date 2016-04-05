package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.fragment.FragmentHome;

/**
 * 适配的代码，来自张弘扬
 */

public class AutoLActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_layout);

        getSupportFragmentManager().beginTransaction().add(R.id.container,new FragmentHome()).commit();
    }
}
