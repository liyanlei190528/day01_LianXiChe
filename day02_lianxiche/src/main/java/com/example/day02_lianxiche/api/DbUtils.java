package com.example.day02_lianxiche.api;

import com.example.day02_lianxiche.bean.DbBean;
import com.example.day02_lianxiche.dao.DaoMaster;
import com.example.day02_lianxiche.dao.DaoSession;
import com.example.day02_lianxiche.dao.DbBeanDao;

import java.util.List;

public class DbUtils {

    private volatile static DbUtils dbUtils;
    private final DbBeanDao dbBeanDao;

    private DbUtils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "qwe.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        dbBeanDao = daoSession.getDbBeanDao();
    }

    public static DbUtils getDbUtils() {
        if (dbUtils== null){
            synchronized (DbUtils.class){
                if (dbUtils == null){
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }


        public void insert(DbBean dbBean) {
            if (has(dbBean)) {
                return;
            }
            dbBeanDao.insertOrReplace(dbBean);

        }

        public void delete(DbBean dbBean) {
            if (has(dbBean)) {
                dbBeanDao.delete(dbBean);
            }
        }

        public List<DbBean> queryAll() {
            return dbBeanDao.queryBuilder().list();

        }

        public DbBean query(DbBean dbBean) {
            DbBean unique = dbBeanDao.queryBuilder().where(DbBeanDao.Properties.Thumbnail.eq(dbBean.getThumbnail())).build().unique();
            return unique;
        }

        public boolean has(DbBean dbBean) {
            List<DbBean> list = dbBeanDao.queryBuilder().where(DbBeanDao.Properties.Title.eq(dbBean.getTitle()), DbBeanDao.Properties.Thumbnail.eq(dbBean.getThumbnail())).list();
            if (list.size() > 0) {
                return true;
            }
            return false;
        }
}
