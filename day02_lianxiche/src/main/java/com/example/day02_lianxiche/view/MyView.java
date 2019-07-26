package com.example.day02_lianxiche.view;

import com.example.day02_lianxiche.bean.HotBean;

public interface MyView {
    void onSuccess(HotBean hotBean);
    void onField(String msg);
}
