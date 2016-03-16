package com.example.xiong.xionglearing.xcc.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;

/**
 * Created by Administrator on 2016/2/18.
 */
public class XiongViewHolder extends RecyclerView.ViewHolder {
    TextView text;

    public XiongViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.tv_recyclerview);
    }
    public TextView getText() {
        return text;
    }
}
