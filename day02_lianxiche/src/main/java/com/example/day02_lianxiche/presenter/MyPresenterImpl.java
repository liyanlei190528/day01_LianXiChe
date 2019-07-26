package com.example.day02_lianxiche.presenter;

import com.example.day02_lianxiche.bean.HotBean;
import com.example.day02_lianxiche.callback.MyCallBack;
import com.example.day02_lianxiche.model.MyMolde;
import com.example.day02_lianxiche.view.MyView;

public class MyPresenterImpl implements MyPresenter {
    private MyMolde myMolde;
    private MyView myView;

    public MyPresenterImpl(final MyMolde myMolde, final MyView myView) {
        this.myMolde = myMolde;
        this.myView = myView;
    }

    @Override
    public void getDate() {
        if (myMolde!=null){
            myMolde.getDate(new MyCallBack() {
                @Override
                public void onSuccess(final HotBean hotBean) {
                    if (myView!=null){
                        myView.onSuccess(hotBean);
                    }
                }

                @Override
                public void onField(final String msg) {
                    if (myView!=null){
                        myView.onField(msg);
                    }
                }
            });
        }
    }
}
