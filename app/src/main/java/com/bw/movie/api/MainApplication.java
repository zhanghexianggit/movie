package com.bw.movie.api;

import android.app.Application;
import android.content.Context;

import com.bw.movie.database.DaoMaster;
import com.bw.movie.database.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Describe：MainApplication
 * Author：fan
 * Data：2019/11/7
 * Time:9:13
 */

public class MainApplication extends Application {
    private static MainApplication sInstance;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Fresco.initialize(this);
        daoSession = DaoMaster.newDevSession ( sInstance, "user_db" );
    }

    public static Context getInstance() {
        return sInstance;
    }

    public static DaoSession getDaosession(){
        return daoSession;
    }
}
