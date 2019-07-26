package com.example.day02_lianxiche.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long Id;

    private String thumbnail;
  
    private String title;

    @Generated(hash = 1080073839)
    public DbBean(Long Id, String thumbnail, String title) {
        this.Id = Id;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    @Generated(hash = 1953169116)
    public DbBean() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
