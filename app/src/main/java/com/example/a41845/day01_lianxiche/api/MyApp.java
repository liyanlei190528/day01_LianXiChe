package com.example.a41845.day01_lianxiche.api;

import android.app.Application;

import com.example.a41845.day01_lianxiche.dao.DaoMaster;
import com.example.a41845.day01_lianxiche.dao.DaoSession;

public class MyApp extends Application {


    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initDate();
    }

    private void initDate() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "gril.db");


        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
