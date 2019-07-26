package com.example.day02_lianxiche.api;

import com.example.day02_lianxiche.bean.HotBean;
import com.example.day02_lianxiche.bean.ZhiHuDetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServer {
    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/hot")
    Observable<HotBean> getDate();

    /**
     * 日报详情页面
     */
    @GET("news/{id}")
    Observable<ZhiHuDetailBean> getZhihuDetails(@Path("id") String newsId);
}
