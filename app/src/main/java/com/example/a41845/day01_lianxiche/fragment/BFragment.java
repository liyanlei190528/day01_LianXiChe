package com.example.a41845.day01_lianxiche.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a41845.day01_lianxiche.Main2Activity;
import com.example.a41845.day01_lianxiche.Main3Activity;
import com.example.a41845.day01_lianxiche.R;
import com.example.a41845.day01_lianxiche.adapter.MyAdapter_B;
import com.example.a41845.day01_lianxiche.api.DbHelper;
import com.example.a41845.day01_lianxiche.bean.ResultsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    private RecyclerView mRv;
    private MyAdapter_B myAdapter_b;
    private List<ResultsBean> list;



    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    @Override
    public void onHiddenChanged(final boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            return;
        }else {
            initDate();
        }
    }

    private void initDate() {
        list = DbHelper.queryAll();

        myAdapter_b = new MyAdapter_B(getActivity(), list);
        mRv.setAdapter(myAdapter_b);
        myAdapter_b.notifyDataSetChanged();
        myAdapter_b.setOnCilck(new MyAdapter_B.OnCilck() {
            @Override
            public void onItem(final int position, final ResultsBean resultsBean) {
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                intent.putExtra("url",resultsBean.getUrl());
                intent.putExtra("desc",resultsBean.getDesc());
                startActivity(intent);
            }
        });

    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv1);

       mRv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
