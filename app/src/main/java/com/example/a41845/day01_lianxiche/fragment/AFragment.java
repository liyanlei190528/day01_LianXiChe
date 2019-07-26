package com.example.a41845.day01_lianxiche.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a41845.day01_lianxiche.R;
import com.example.a41845.day01_lianxiche.adapter.MyAdapter_A;
import com.example.a41845.day01_lianxiche.api.MyServer;
import com.example.a41845.day01_lianxiche.bean.ResultsBean;
import com.example.a41845.day01_lianxiche.bean.RootBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private View view;
    private RecyclerView mRv;
    private ArrayList<ResultsBean> list;
    private MyAdapter_A myAdapter_a;
    private int page = 1;

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
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<RootBean> date = myServer.getDate(page);
        date.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final RootBean rootBean) {
                        list.addAll(rootBean.getResults());
                        myAdapter_a.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(final Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        list = new ArrayList<>();
        myAdapter_a = new MyAdapter_A(getActivity(), list);
        mRv.setAdapter(myAdapter_a);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
