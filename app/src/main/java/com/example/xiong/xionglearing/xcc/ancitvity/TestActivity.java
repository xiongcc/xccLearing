package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.model.CricleInfo;
import com.example.xiong.xionglearing.xcc.view.MyLinearView;

import java.util.ArrayList;

public class TestActivity extends FragmentActivity {
    ArrayList<CricleInfo> list;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView i1;
    private ImageView i2;
    private ImageView i3;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    float x4;
    float y4;
    boolean hasMeasured = false;
    private MyLinearView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);


        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        i1 = (ImageView) findViewById(R.id.i1);
        i2 = (ImageView) findViewById(R.id.i2);
        i3 = (ImageView) findViewById(R.id.i3);
        view = (MyLinearView) findViewById(R.id.linearView);

        ViewTreeObserver vto = imageView3.getViewTreeObserver();

        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (hasMeasured == false) {

                    int[] location = new int[2];
                    imageView1.getLocationOnScreen(location);
                    int[] location2 = new int[2];
                    imageView2.getLocationOnScreen(location2);
                    int[] location3 = new int[2];
                    imageView3.getLocationOnScreen(location3);
                    int[] location4 = new int[2];
                    imageView4.getLocationOnScreen(location4);


                    x1 = location[0] + imageView1.getWidth() / 2;
                    y1 = location[1] + imageView1.getHeight() / 2;
                    x2 = location2[0] + imageView2.getWidth() / 2;
                    y2 = location2[1] + imageView2.getHeight() / 2;
                    x3 = location3[0] + imageView3.getWidth() / 2;
                    y3 = location3[1] + imageView3.getHeight() / 2;
                    x4 = location4[0] + imageView4.getWidth() / 2;
                    y4 = location4[1] + imageView4.getHeight() / 2;


                    for (int i = 0; i < location3.length; i++) {

                        Log.e("tag", location3[i] + "");
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
             AnimatorHelper.playTranXAnimSet(i1,0,0);
             AnimatorHelper.playTranXAnimSet(i2,0,0);
             AnimatorHelper.playTranXAnimSet(i3,0,0);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startPosition(x2, y2);
                view.moveTo(x3, y3);
                view.invalidate();
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startPosition(x3, y3);
                view.moveTo(x4, y4);
                view.invalidate();
            }
        }, 3000);


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
//    public void haha(View s) {
//
//        TestModel tm = new TestModel();
//        tm.setStandard_code("您的得分是0分");
//        TestModel.MarkItemsEntity me = new TestModel.MarkItemsEntity();
//        me.setRemark("写了解");
//        me.setScore("0分");
//        TestModel.MarkItemsEntity me2 = new TestModel.MarkItemsEntity();
//        me2.setRemark("写了解你猜");
//        me2.setScore("1分");
//        List<TestModel.MarkItemsEntity> list = new ArrayList<>();
//        list.add(me);
//        list.add(me2);
//        tm.setMark_items(list);
//
//
////        MyScoreView myScoreView = (MyScoreView) findViewById(R.id.view2);
////        myScoreView.refush();
//        Log.e("tag", "tm=" + tm.toString());
//    }
//
//    class TestAdapter extends RecyclerView.Adapter<TextViewHodler> {
//
//
//        @Override
//        public TextViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.e("tag", "onCreateViewHolder");
//            return new TextViewHodler(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, null));
//        }
//
//        @Override
//        public void onBindViewHolder(TextViewHodler holder, int position) {
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size() * 2;
//        }
//    }
//
//    CricleView cv;
//
//    class TextViewHodler extends RecyclerView.ViewHolder {
//
//        public TextViewHodler(View itemView) {
//            super(itemView);
//            cv = (CricleView) itemView.findViewById(R.id.vricle_test);
//            cv.drawing(list);
//        }
//
//
//    }

}

