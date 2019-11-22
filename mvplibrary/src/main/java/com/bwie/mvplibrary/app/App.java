package com.bwie.mvplibrary.app;

import android.app.Application;
import android.content.Context;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class App extends Application {
    public static App sContent;

    @Override
    public void onCreate() {
        super.onCreate ();
        sContent = this;
    }

    public static App getsContent() {
        return sContent;
    }
}
