package com.example.xiong.xionglearing.xcc.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/24.
 */
public class HorizontalListViewAdapter extends BaseAdapter {
    private Context mContext;
    private Map<Integer, Boolean> map = new HashMap<>();
    private int currentPosition = -1;

    public HorizontalListViewAdapter(Context context) {
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHodler vh;
        if (view == null) {
            vh = new ViewHodler();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_horlistview, null);
            vh.imagge = (ImageView) view.findViewById(R.id.img_item);
            vh.tx_position = (TextView) view.findViewById(R.id.tx_position);
            view.setTag(vh);
        } else {
            vh = (ViewHodler) view.getTag();
        }
        vh.tx_position.setText(i + "");
        Log.e("tag", "getView=i=" + i);
//        if(i==0)
//        vh.imagge.setBackgroundResource(R.drawable.shape_rectangle);
//        if (i == 0)
//            map.put(i, true);
//        else
//            map.put(i, false);
//        vh.imagge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                vh.imagge.setBackgroundResource(R.drawable.shape_rectangle);
//                Log.e("tag","55555");
//            }
//        });
//
        if (currentPosition == i)
            vh.imagge.setBackgroundResource(R.drawable.shape_rectangle);
        else
            vh.imagge.setBackground(null);

        return view;
    }


    static class ViewHodler {
        ImageView imagge;
        TextView tx_position;
    }

    public void resetMap() {

        for (int i = 0; i < map.size(); i++) {
                map.put(i, false);
        }

    }

    public void setImgBackground(int position, int count) {
        currentPosition = position;
        for (int i = 0; i < count; i++) {
            if (position == i)
                map.put(i, true);
            else
                map.put(i, false);
        }
        Log.e("tag", "position=" + position);

//        map.put(position,true);
//        notifyDataSetChanged();

//        for (int i = 0; i < map.size(); i++) {
//                map.get(position).imagge.setBackground(null);
//        }
//        map.get(position).imagge.setBackgroundResource(R.drawable.shape_rectangle);
    }


}
