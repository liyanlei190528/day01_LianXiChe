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
import com.example.day02_lianxiche.bean.DbBean;


import java.util.ArrayList;

public class MyAdapter_b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final FragmentActivity activity;
    private final ArrayList<DbBean> list;

    public MyAdapter_b(final FragmentActivity activity, final ArrayList<DbBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        if (i == 0){
            View view=  View.inflate(activity,R.layout.layout_item,null);
            return new ViewHolder1(view);
        }else {
            View view=  View.inflate(activity,R.layout.layout_item2,null);
            return new ViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        DbBean dbBean = list.get(i);
        if (type == 0) {
            ViewHolder1 holder1 = (ViewHolder1) viewHolder;
            holder1.title.setText(dbBean.getTitle());
            Glide.with(activity)
                    .load(dbBean.getThumbnail())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder1.img);

        } else {
            ViewHolder2 holder2 = (ViewHolder2) viewHolder;
            holder2.title.setText(dbBean.getTitle());
            Glide.with(activity)
                    .load(dbBean.getThumbnail())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder2.img);
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(final int position) {
        if (position%2 ==0){
            return 0;
        }else {
            return 1;
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder1(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public ViewHolder2(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
