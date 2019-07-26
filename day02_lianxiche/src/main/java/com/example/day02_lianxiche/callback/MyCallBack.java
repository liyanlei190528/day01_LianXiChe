package com.example.day02_lianxiche.callback;

import com.example.day02_lianxiche.bean.HotBean;

public interface MyCallBack {
    void onSuccess(HotBean hotBean);
    void onField(String msg);
}
