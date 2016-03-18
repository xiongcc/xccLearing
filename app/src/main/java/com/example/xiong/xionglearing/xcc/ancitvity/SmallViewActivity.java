package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.view.TriangleView;

/*
比较小的自定义控件集合
 */
public class SmallViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_view);
        //一个下拉指示器的三角新按钮
        TriangleView triangle = (TriangleView) findViewById(R.id.TriangleView);
        triangle.setTriangleCallBack(new TriangleView.onTriangleViewListtener() {
            @Override
            public void clickMe() {
                Log.e("tag","come on!");
            }
        });

    }
}
