package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.Adapter.HorizontalListViewAdapter;
import com.example.xiong.xionglearing.xcc.listview.HorizontalListView;

public class HorzListViewActivity extends AppCompatActivity {
    private  String[] str = {"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};
    private HorizontalListView hl;
    private ImageView img_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horz_list_view);
        hl = (HorizontalListView) findViewById(R.id.horizontalListView);
        img_indicator = (ImageView) findViewById(R.id.img_indicator);
       final HorizontalListViewAdapter adapter =   new HorizontalListViewAdapter(this);
        adapter.setImgBackground(0,20);
        hl.setAdapter(adapter);
//        Log.e("tag", "adapter.getCount()="+adapter.getCount());

        hl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                adapter.resetMap();
                adapter.setImgBackground(i, 20);
                adapter.notifyDataSetChanged();
//                int width = view.getWidth();
//                int left = view.getLeft();
//                view
                Log.e("tag", "setOnItemClickListener=");
//                Animation ani = new TranslateAnimation(0, left, 0, 0);
//                ani.setDuration(1000);
//                ani.setFillAfter(true);
//                adapter.setImgBackground(i);
//                img_indicator.startAnimation(ani);
//                hl.gets

            }
        });
    }
}
