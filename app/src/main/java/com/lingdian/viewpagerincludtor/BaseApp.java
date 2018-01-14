package com.lingdian.viewpagerincludtor;

import android.app.Application;
import android.content.Context;

/**
 * Created by lingdian on 2018/1/12.
 */

public class BaseApp extends Application{

    //全局应用上下文
    private static Context mAppContext;
    private static Context mAppContextTmp;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppContextTmp = this;

    }
    /*
	 * 获得全局上下文
	 */
    public static Context getAppContext() {
        if (mAppContext == null) {
            return mAppContextTmp;
        }
        return mAppContext;
    }
}
