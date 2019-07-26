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
import com.example.a41845.day01_lianxiche.api.DbHelper;
import com.example.a41845.day01_lianxiche.bean.ResultsBean;

import java.util.ArrayList;

public class MyAdapter_A extends RecyclerView.Adapter<MyAdapter_A.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<ResultsBean> list;

    public MyAdapter_A(final FragmentActivity activity, final ArrayList<ResultsBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(activity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final ResultsBean dateBean = list.get(i);
        viewHolder.title.setText(dateBean.getDesc());
        Glide.with(activity)
                .load(dateBean.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.img);
        viewHolder.cb.setChecked(dateBean.getColler());
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (viewHolder.cb.isChecked()){
                    dateBean.setColler(true);
                    notifyDataSetChanged();
                    DbHelper.insert(dateBean);
                }else {
                    dateBean.setColler(false);

                    // DbHelper.getDbHelper().delete(dataBean);
                    notifyDataSetChanged();
                }
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
        private CheckBox cb;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            cb = itemView.findViewById(R.id.cb);
        }
    }
}
