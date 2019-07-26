package com.example.a41845.day01_lianxiche.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class ResultsBean {
    @Id(autoincrement = true)
    private Long id;
    private String desc;
    private String url;
    private boolean Coller;
    @Generated(hash = 164278592)
    public ResultsBean(Long id, String desc, String url, boolean Coller) {
        this.id = id;
        this.desc = desc;
        this.url = url;
        this.Coller = Coller;
    }
    @Generated(hash = 1822271928)
    public ResultsBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean getColler() {
        return this.Coller;
    }
    public void setColler(boolean Coller) {
        this.Coller = Coller;
    }

}
