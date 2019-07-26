package com.example.a41845.day01_lianxiche.api;






import com.example.a41845.day01_lianxiche.bean.ResultsBean;

import com.example.a41845.day01_lianxiche.dao.DaoSession;
import com.example.a41845.day01_lianxiche.dao.ResultsBeanDao;


import java.util.List;

public class DbHelper  {


    public static void insert(ResultsBean resultsBean){
        DaoSession daoSession = MyApp.getDaoSession();
        ResultsBean resultsBean1 = queryOne(resultsBean.getDesc());
        if (resultsBean1!=null){

        }else {
            daoSession.insert(resultsBean);
        }
    }

    public static void delete(ResultsBean resultsBean){
        DaoSession daoSession = MyApp.getDaoSession();
        ResultsBean resultsBean1 = queryOne(resultsBean.getDesc());
        if (resultsBean1==null){

        }else {
            daoSession.delete(resultsBean);
        }
    }

    public static List<ResultsBean> queryAll(){
        DaoSession daoSession = MyApp.getDaoSession();
        return daoSession.loadAll(ResultsBean.class);
    }
    public static void update(String desc,String newdesc){
        DaoSession daoSession = MyApp.getDaoSession();
        ResultsBean resultsBean = queryOne(desc);
        if (resultsBean!=null){
            resultsBean.setDesc(newdesc);
            daoSession.update(resultsBean);
        }
    }

    public static ResultsBean queryOne(String desc){
        DaoSession daoSession = MyApp.getDaoSession();
        return daoSession.queryBuilder(ResultsBean.class)
                .where(ResultsBeanDao.Properties.Desc.eq(desc))
                .build()
                .unique();
    }

}
