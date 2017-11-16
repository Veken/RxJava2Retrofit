package com.veken.rxjavaretrofitdemo.net.present;

import android.content.Context;


import com.veken.rxjavaretrofitdemo.module.bean.LoginRespond;
import com.veken.rxjavaretrofitdemo.net.DefaultObserver;
import com.veken.rxjavaretrofitdemo.net.bean.UserInfoBean;
import com.veken.rxjavaretrofitdemo.net.request.UserInfoRequest;

import java.util.HashMap;

import io.reactivex.annotations.NonNull;

/**
 * @author Veken
 * @date on 2017/11/15 18:12
 * @describe
 */

public class UserInfoPresent  {

    private UserInfoRequest userInfoRequest;
    private Context context;
    private UserInfoBean userInfoBean;

    public UserInfoPresent( Context context, UserInfoBean userInfoBean) {
        this.context = context;
        this.userInfoBean = userInfoBean;
        userInfoRequest = new UserInfoRequest();
    }

    public void login() {

        HashMap<String, Object> fieldsMap = new HashMap<>();
        fieldsMap.put("phoneNo", userInfoBean.getPhoneNum());
        fieldsMap.put("password", userInfoBean.getPwd());

        userInfoRequest.login(new DefaultObserver<LoginRespond>(context,true) {
            @Override
            public void onSuccess(LoginRespond response) {
                userInfoBean.onSuccess(response);
            }

            @Override
            public void onNext(@NonNull LoginRespond o) {
                userInfoBean.onSuccess(o);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                userInfoBean.onError(e);
            }
        }, fieldsMap);
    }
}
