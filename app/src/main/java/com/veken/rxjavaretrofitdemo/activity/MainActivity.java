package com.veken.rxjavaretrofitdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.veken.rxjavaretrofitdemo.R;
import com.veken.rxjavaretrofitdemo.module.bean.LoginRespond;
import com.veken.rxjavaretrofitdemo.net.bean.UserInfoBean;
import com.veken.rxjavaretrofitdemo.net.request.UserInfoRequest;


public class MainActivity extends BaseActivity implements UserInfoBean {
    private Button btn;
    private UserInfoRequest userInfoRequest;
    private TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initView() {
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        userInfoRequest= new UserInfoRequest(this,this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfoRequest.login();
            }
        });
    }

    //传递的用户
    @Override
    public String getPhoneNum() {
        //根据需要，传递相应的数据
        return "登录账号";
    }

    //传递的密码
    @Override
    public String getPwd() {
        //根据需要，传递相应的数据
        return "登录密码";
    }

    //数据返回
    @Override
    public void onSuccess(Object object) {
        LoginRespond loginRespond = (LoginRespond) object;
        Log.d("登录信息:", loginRespond.getResDesc());
        tv.setText(loginRespond.getData().getTelphone());
    }

    @Override
    public void onError(Throwable e) {

    }
}
