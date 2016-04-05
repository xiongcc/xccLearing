package com.example.xiong.xionglearing.xcc.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xiong.xionglearing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/18.
 */
public class XiongViewHolder extends RecyclerView.ViewHolder {
    TextView text;
    TextView tv_indicator;
    private List<TextView> list = new ArrayList<>();
    public XiongViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.tv_recyclerview);
//        tv_indicator = (TextView) itemView.findViewById(R.id.tv_indicator);

    }
    public TextView getText() {
        return text;
    }
    public TextView gettv_indicator() {
        return tv_indicator;
    }


}
