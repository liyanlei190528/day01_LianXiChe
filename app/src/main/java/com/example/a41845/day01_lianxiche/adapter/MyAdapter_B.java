package com.example.a41845.day01_lianxiche.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.a41845.day01_lianxiche.R;
import com.example.a41845.day01_lianxiche.bean.ResultsBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter_B extends RecyclerView.Adapter<MyAdapter_B.ViewHolder> {


    private  FragmentActivity activity;
    private  List<ResultsBean> list;

    public MyAdapter_B(final FragmentActivity activity, final List<ResultsBean> list) {

        this.activity = activity;
        this.list = list;
    }

    public void setList(final List<ResultsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(activity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final ResultsBean resultsBean = list.get(i);
        final ViewHolder holder = viewHolder;
        holder.title.setText(resultsBean.getDesc());
        Glide.with(activity)
                .load(resultsBean.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onCilck.onItem(i,resultsBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
       private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.title);
            img =itemView.findViewById(R.id.img);
        }
    }

    private OnCilck onCilck;

    public void setOnCilck(final OnCilck onCilck) {
        this.onCilck = onCilck;
    }

    public interface OnCilck{
        void onItem(int position,ResultsBean resultsBean);
    }
}
