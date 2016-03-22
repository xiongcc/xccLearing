package com.example.xiong.xionglearing.xcc.ancitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;

public class ExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);


        ExpandableListView sampleList = (ExpandableListView) findViewById(R.id.sample_list);

        sampleList.setAdapter(new SampleAdapter());
    }


    class SampleAdapter extends BaseExpandableListAdapter{


        @Override
        public int getGroupCount() {
            return 10;
        }

        @Override
        public int getChildrenCount(int i) {
            return 3;
        }

        @Override
        public Object getGroup(int i) {
            return null;
        }

        @Override
        public Object getChild(int i, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {


//            if(view == null){
                 view = LayoutInflater.from(ExpandableActivity.this).inflate(R.layout.expand_parent_item, null);
                TextView t1__parent_expand = (TextView) view.findViewById(R.id.t1__parent_expand);
//            }


            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(ExpandableActivity.this).inflate(R.layout.expand_child_item, null);
            TextView t1_expand = (TextView) view.findViewById(R.id.t1_expand);
            ImageView img_expand = (ImageView) view.findViewById(R.id.img_expand);
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }



}
