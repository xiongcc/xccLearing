package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.example.xiong.xionglearing.R;

/**
 * ScorllViewd的一些相关测试
 */
public class ScorllViewActivity extends AppCompatActivity {

    private ScrollView sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorll_view);
        sc = (ScrollView) findViewById(R.id.scrollView2);






    }
    public void test(View s){
        int height = sc.getHeight();

        Log.e("tag",height+"");
        sc.scrollTo(100,100);


    }
}
