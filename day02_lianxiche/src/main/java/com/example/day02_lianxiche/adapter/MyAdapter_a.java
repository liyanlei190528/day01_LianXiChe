package com.example.day02_lianxiche.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day02_lianxiche.R;
import com.example.day02_lianxiche.bean.HotBean;

import java.util.ArrayList;

public class MyAdapter_a extends RecyclerView.Adapter<MyAdapter_a.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<HotBean.RecentBean> list;

    public MyAdapter_a(final FragmentActivity activity, final ArrayList<HotBean.RecentBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view=  View.inflate(activity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final HotBean.RecentBean recentBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(recentBean.getTitle());
        Glide.with(activity)
                .load(recentBean.getThumbnail())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClick.onItem(i,recentBean);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                onLongClick.onLongItem(i,recentBean);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);

            title = itemView.findViewById(R.id.title);
        }
    }
    private OnClick onClick;

    public void setOnClick(final OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick{
        void onItem(int position,HotBean.RecentBean recentBean);
    }

private OnLongClick onLongClick;

    public void setOnLongClick(final OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }

    public interface OnLongClick{
        void onLongItem(int position,HotBean.RecentBean recentBean);
    }
}
