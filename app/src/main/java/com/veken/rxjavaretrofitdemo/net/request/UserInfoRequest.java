package com.veken.rxjavaretrofitdemo.net.request;


import com.veken.rxjavaretrofitdemo.net.DefaultObserver;
import com.veken.rxjavaretrofitdemo.net.RetrofitConnect;
import com.veken.rxjavaretrofitdemo.net.SubScriberHandler;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @author Veken
 * @date on 2017/11/15 18:01
 * @describe
 */

public class UserInfoRequest extends SubScriberHandler {

    public void login(DefaultObserver defaultObserver, Map<String, Object> fields) {

        fields.put("method", "user.login");
        handleFields(fields);
        Observable observable = RetrofitConnect.getApiService().login(fields);
        toSubscribe(observable,defaultObserver);
    }


}
