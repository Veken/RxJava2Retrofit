package com.veken.rxjavaretrofitdemo.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.veken.rxjavaretrofitdemo.utils.ToastUtils;

public abstract class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData(savedInstanceState);
        initView();
    }

    protected abstract void initView();

    protected void showToast(String msg) {
        ToastUtils.show(msg);
    }

    /**
     * 布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);
}
