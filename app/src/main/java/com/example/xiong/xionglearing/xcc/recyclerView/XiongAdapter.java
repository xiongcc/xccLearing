package com.example.xiong.xionglearing.xcc.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiong.xionglearing.R;

import java.util.List;

/**
 * Created by Administrator on 2016/2/18.
 */
public class XiongAdapter extends RecyclerView.Adapter<XiongViewHolder> {

    public List<String> mLists;

    public XiongAdapter(List<String> mLists) {
        this.mLists = mLists;
    }

    @Override
    public XiongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycle, null);
        return new XiongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final XiongViewHolder holder, final int position) {
        holder.getText().setText(mLists.get(position));
        Log.e("xiong", position + "");

        holder.getText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("position", position + "");
                if (click != null)
                    click.setOnMyClickListener(position);
            }
        });
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
