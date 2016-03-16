package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.recyclerView.MyAdapter;
import com.example.xiong.xionglearing.xcc.recyclerView.XiongAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity {

    /**
     * 数据集合
     */
    private List<String> mDatas;

    //控件
    private RecyclerView mRecyclerView;

    //适配器
    private MyAdapter mAdapter;
    private XiongAdapter xiongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mDatas = new ArrayList<>();
        ininViews();
        initData();
        initMyAdapter();
        int i = 2;
//        initAdapter();
    }

    private void initMyAdapter() {
        xiongAdapter = new XiongAdapter(mDatas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(xiongAdapter);
        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        xiongAdapter.setItemClickListener(new XiongAdapter.setClick() {
            @Override
            public void setOnMyClickListener(int position) {
                Log.e("ss", position + "");
            }
        });
    }

    //初始化布局控件
    private void ininViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
    }
//
//    private void initAdapter() {
//        //初始化adapter
//        mAdapter = new MyAdapter(mDatas);
//        /**
//         * Support库提供了两个现成的子类：LinearLayoutManager和StaggeredGridLayoutManager。
//         * 前者可以获得和ListView一样的布局，还可以是水平方向的；后者则提供了形如GridView的布局。
//         */
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        //设置adapter
//        mRecyclerView.setAdapter(mAdapter);
//        //画横线
////        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//
//        //默认动画   貌似官方就提供了这一种默认的动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//
//        /**
//         * 在这我们就能实现item的点击事件了
//         */
//        mAdapter.setListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(View v, int position, String str) {
//                Toast.makeText(RecyclerviewActivity.this, "点击我干嘛啊,真是没事找事", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
    /**
     * 添加事件
     *
     * @param view
     */
    public void btnAdd(View view) {
//        mAdapter.addData("小红", 3);
    }

    /**
     * 删除事件
     *
     * @param view
     */
    public void btnDelete(View view) {

//        mAdapter.remove(4);
    }

    /**
     * 初始化集合数据
     */
    private void initData() {
        mDatas.add("New York");
        mDatas.add("Bei Jing");
        mDatas.add("Boston");
        mDatas.add("London");
        mDatas.add("San Francisco");
        mDatas.add("Chicago");
        mDatas.add("Shang Hai");
        mDatas.add("Tian Jin");
        mDatas.add("Zheng Zhou");
        mDatas.add("Hang Zhou");
        mDatas.add("Guang Zhou");
        mDatas.add("Fu Gou");
        mDatas.add("Zhou Kou");
        mDatas.add("New York");
        mDatas.add("Bei Jing");
        mDatas.add("Boston");
        mDatas.add("London");
        mDatas.add("Zhou Kou");
        mDatas.add("Zhou Kou");
        mDatas.add("Zhou Kou");
        mDatas.add("Zhou Kou");
        mDatas.add("Zhou Kou");
    }
}
