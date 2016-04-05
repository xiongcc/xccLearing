package com.example.xiong.xionglearing.xcc.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/18.
 */
public class XiongAdapter extends RecyclerView.Adapter<XiongViewHolder> {

    public List<String> mLists;
    private Map<Integer,TextView> map = new HashMap<>();

    int mClickPos = -1;

    public XiongAdapter(List<String> mLists) {
        this.mLists = mLists;
    }

    @Override
    public XiongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.e("xiong",   "onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycle, null);
        return new XiongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final XiongViewHolder holder, final int position) {
        holder.getText().setText(mLists.get(position));
//        Log.e("xiong", position + "");
//        list.add(holder.gettv_indicator());
        map.put(position,holder.getText());

        holder.getText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("position", position + "");
                mClickPos = position;
//                if (click != null)
//                    click.setOnMyClickListener(position);
//                for (int i = 0; i < map.size(); i++) {
//                    map.get(position).setBackgroundResource(R.drawable.shape_englno);
//                }
//                map.get(position).setBackgroundResource(R.drawable.shape_engl);
//
                notifyDataSetChanged();;
            }


        });

        map.get(position).setBackground(null);
        if(position == mClickPos){
            map.get(position).setBackgroundResource(R.drawable.shape_engl);
        }
    }

    public setClick click;

    @Override
    public int getItemCount() {
        return mLists.size();

    }

    public void setItemClickListener(setClick click) {
        this.click = click;
    }

    public interface setClick {
        void setOnMyClickListener(int position);
    }
}
