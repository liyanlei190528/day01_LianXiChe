package com.example.day02_lianxiche.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day02_lianxiche.R;
import com.example.day02_lianxiche.adapter.MyAdapter_b;
import com.example.day02_lianxiche.api.DbUtils;
import com.example.day02_lianxiche.bean.DbBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    private View view;
    private RecyclerView mRv;
    private SmartRefreshLayout mSrl;
    private ArrayList<DbBean>  list = new ArrayList<>();
    private MyAdapter_b myAdapter_b;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(final boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
           initDate();
        }else {
            list.clear();
        }
    }

    private void initDate() {
        List<DbBean> dbBeans = DbUtils.getDbUtils().queryAll();
        list.addAll(dbBeans);
        myAdapter_b.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mSrl = (SmartRefreshLayout) inflate.findViewById(R.id.srl);



        myAdapter_b = new MyAdapter_b(getActivity(), list);
        mRv.setAdapter(myAdapter_b);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
