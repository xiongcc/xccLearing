package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.menu.CricleView;
import com.example.xiong.xionglearing.xcc.model.CricleInfo;
import com.example.xiong.xionglearing.xcc.test.TestModel;
import com.example.xiong.xionglearing.xcc.view.MyLinearView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends FragmentActivity {
    ArrayList<CricleInfo> list;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    boolean hasMeasured = false;
    private MyLinearView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);





        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        view = (MyLinearView) findViewById(R.id.linearView);

        ViewTreeObserver vto = imageView3.getViewTreeObserver();

        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (hasMeasured == false) {

                    int[] location = new int[2];

                    imageView1.getLocationOnScreen(location);

//                 int x =    imageView1.getParent().getLeft();

                    for(int i = 0;i<location.length;i++){


                    }
//                    Log.e("tag", "x1=" + x1 + "  y1=" + y1 + " t=" + top);
                    hasMeasured = true;


                }
                return true;
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startPosition(x1, y1);
                view.moveTo(x2, y2);
                view.invalidate();
            }
        }, 2000);
//        View container = findViewById(R.id.container);

//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.container,new TestFragment()).commit();
//        list = new ArrayList<>();
//        list.add(new CricleInfo(0, 0, 1));
//        list.add(new CricleInfo(0, 0, 2));
//        list.add(new CricleInfo(0, 0, 33));
//        list.add(new CricleInfo(0, 0, 4));
//        list.add(new CricleInfo(0, 0, 5));
//        list.add(new CricleInfo(0, 0, 6));
//        list.add(new CricleInfo(0, 0, 6));
//        list.add(new CricleInfo(0, 0, 63));
//        list.add(new CricleInfo(0, 0, 6));
//        list.add(new CricleInfo(0, 0, 6));
//        RecyclerView rv = (RecyclerView) findViewById(R.id.textRecycleView);
//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rv.setAdapter(new TestAdapter());
////
//      cricle.drawing(list);

    }

    public void haha(View s) {

        TestModel tm = new TestModel();
        tm.setStandard_code("您的得分是0分");
        TestModel.MarkItemsEntity me = new TestModel.MarkItemsEntity();
        me.setRemark("写了解");
        me.setScore("0分");
        TestModel.MarkItemsEntity me2 = new TestModel.MarkItemsEntity();
        me2.setRemark("写了解你猜");
        me2.setScore("1分");
        List<TestModel.MarkItemsEntity> list = new ArrayList<>();
        list.add(me);
        list.add(me2);
        tm.setMark_items(list);


//        MyScoreView myScoreView = (MyScoreView) findViewById(R.id.view2);
//        myScoreView.refush();
        Log.e("tag", "tm=" + tm.toString());
    }

    class TestAdapter extends RecyclerView.Adapter<TextViewHodler> {


        @Override
        public TextViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.e("tag", "onCreateViewHolder");
            return new TextViewHodler(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, null));
        }

        @Override
        public void onBindViewHolder(TextViewHodler holder, int position) {

        }

        @Override
        public int getItemCount() {
            return list.size() * 2;
        }
    }

    CricleView cv;

    class TextViewHodler extends RecyclerView.ViewHolder {

        public TextViewHodler(View itemView) {
            super(itemView);
            cv = (CricleView) itemView.findViewById(R.id.vricle_test);
            cv.drawing(list);
        }


    }

}

