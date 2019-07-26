package com.example.day02_lianxiche.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day02_lianxiche.MainActivity;
import com.example.day02_lianxiche.R;
import com.example.day02_lianxiche.WebViewActivity;
import com.example.day02_lianxiche.adapter.MyAdapter_a;
import com.example.day02_lianxiche.api.DbUtils;
import com.example.day02_lianxiche.bean.DbBean;
import com.example.day02_lianxiche.bean.HotBean;
import com.example.day02_lianxiche.model.MyMoldeImpl;
import com.example.day02_lianxiche.presenter.MyPresenterImpl;
import com.example.day02_lianxiche.view.MyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MyView {


    private View view;
    private RecyclerView mRv;
    private SmartRefreshLayout mSrl;
    private ArrayList<HotBean.RecentBean> list;
    private MyAdapter_a myAdapter_a;
    private MyPresenterImpl myPresenter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        myPresenter = new MyPresenterImpl(new MyMoldeImpl(), this);
        myPresenter.getDate();
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mSrl = (SmartRefreshLayout) inflate.findViewById(R.id.srl);

        list = new ArrayList<>();
        myAdapter_a = new MyAdapter_a(getActivity(), list);
        mRv.setAdapter(myAdapter_a);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onSuccess(final HotBean hotBean) {
        list.addAll(hotBean.getRecent());
        myAdapter_a.notifyDataSetChanged();

        myAdapter_a.setOnLongClick(new MyAdapter_a.OnLongClick() {
            @Override
            public void onLongItem(final int position, final HotBean.RecentBean recentBean) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        // .setTitle("是否插入数据库")
                        .setMessage("是否插入数据库")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {
                                DbBean dbBean = new DbBean();
                                dbBean.setId(null);
                                dbBean.setTitle(recentBean.getTitle());
                                dbBean.setThumbnail(recentBean.getThumbnail());
                                DbBean query = DbUtils.getDbUtils().query(dbBean);
                                if (query == null) {
                                    DbUtils.getDbUtils().insert(dbBean);
                                    Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "已存在", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {

                            }
                        })
                        .create();
                dialog.show();
            }
        });


        myAdapter_a.setOnClick(new MyAdapter_a.OnClick() {
            @Override
            public void onItem(final int position, final HotBean.RecentBean recentBean) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
               intent.putExtra("id",recentBean.getNews_id());
               intent.putExtra("src",recentBean.getThumbnail());
                startActivity(intent);


            }
        });
    }

    @Override
    public void onField(final String msg) {
        Toast.makeText(getActivity(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
