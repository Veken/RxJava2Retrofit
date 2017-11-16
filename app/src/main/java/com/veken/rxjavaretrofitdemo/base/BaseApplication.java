package com.veken.rxjavaretrofitdemo.base;

import android.app.Application;
import android.content.Context;

import com.veken.rxjavaretrofitdemo.utils.Utils;


/**
 * Created by edianzu on 2017/4/18.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;
    public static Context getAppContext() {
        return baseApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        baseApplication =this;
    }
}
