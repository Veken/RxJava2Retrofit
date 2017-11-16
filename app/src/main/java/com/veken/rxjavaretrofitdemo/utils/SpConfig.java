package com.veken.rxjavaretrofitdemo.utils;

import android.content.Context;

import com.veken.rxjavaretrofitdemo.base.BaseApplication;


/**
 * SharedPreferences 存储数据
 * @author Veken
 */
public class SpConfig extends PreferenceUtil {

    private static final String YOUR_APP_NAME = "your_app_name";

    public SpConfig() {
        super(YOUR_APP_NAME);
    }

    @Override
    protected Context getContext() {
        return BaseApplication.getAppContext();
    }

    private static class SingletonHolder {
        private static final SpConfig INSTANCE = new SpConfig();
    }

    public static SpConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
