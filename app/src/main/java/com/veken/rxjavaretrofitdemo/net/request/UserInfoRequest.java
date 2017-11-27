package com.veken.rxjavaretrofitdemo.net.request;


import android.content.Context;

import com.veken.rxjavaretrofitdemo.module.bean.BaseRespond;
import com.veken.rxjavaretrofitdemo.module.bean.LoginRespond;
import com.veken.rxjavaretrofitdemo.net.DefaultObserver;
import com.veken.rxjavaretrofitdemo.net.RetrofitConnect;
import com.veken.rxjavaretrofitdemo.net.SubScriberHandler;
import com.veken.rxjavaretrofitdemo.net.bean.UserInfoBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * @author Veken
 * @date on 2017/11/15 18:01
 * @describe
 */

public class UserInfoRequest extends SubScriberHandler {

    private UserInfoBean userInfoBean;
    private Context context;

    public UserInfoRequest(Context context,UserInfoBean userInfoBean) {
        this.context = context;
        this.userInfoBean = userInfoBean;
    }

    public void login() {

        Map<String, Object> fields = new HashMap<>();
        //调用的接口方法，比如login方法
        fields.put("method", "user.login");
        //加密和传一些常用参数
        handleFields(fields);
        //传递需要传递的参数
        fields.put("phoneNo", userInfoBean.getPhoneNum());
        fields.put("password", userInfoBean.getPwd());
        //申请网络
        Observable observable = RetrofitConnect.getApiService().login(fields);
        toSubscribe(observable, new DefaultObserver(context,true) {
            //数据返回在onNext
            @Override
            public void onSuccess(BaseRespond response) {
            }

            @Override
            public void onNext(@NonNull BaseRespond response) {
                userInfoBean.onSuccess(response);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                userInfoBean.onError(e);
            }
        });
    }

}
