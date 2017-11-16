package com.veken.rxjavaretrofitdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.veken.rxjavaretrofitdemo.R;
import com.veken.rxjavaretrofitdemo.module.bean.LoginRespond;
import com.veken.rxjavaretrofitdemo.net.bean.UserInfoBean;
import com.veken.rxjavaretrofitdemo.net.present.UserInfoPresent;


public class MainActivity extends BaseActivity implements UserInfoBean {
    private Button btn;
    private UserInfoPresent userInfoPresent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        userInfoPresent = new UserInfoPresent(this,this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }


    public void getData() {
//        HashMap<String, Object> fieldsMap = new HashMap<>();
//        fieldsMap.put("phoneNo", "13111112222");
//        fieldsMap.put("password", "xingfu13");
//        handleFields(fieldsMap);
//        fieldsMap.put("method", "user.login");
//        RetrofitConnect.getApiService()
//                .login(fieldsMap)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<LoginRespond>() {
//                    @Override
//                    public void accept(@NonNull LoginRespond loginOrRegisterRespond) throws Exception {
//                        showToast(loginOrRegisterRespond.getData().toString());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//
//                    }
//                });
        userInfoPresent.login();
    }

    //传递的用户
    @Override
    public String getPhoneNum() {
        return "你的用户名";
    }

    //传递的密码
    @Override
    public String getPwd() {
        return "你的密码";
    }

    @Override
    public void onSuccess(Object object) {
        LoginRespond loginRespond = (LoginRespond)object;
        Log.d("登录信息:", loginRespond.getResDesc());
    }

    @Override
    public void onError(Throwable e) {

    }
}
