package com.veken.rxjavaretrofitdemo.net.bean;

/**
 * @author Veken
 * @date on 2017/11/15 18:13
 * @describe
 */

public interface BaseBean {
    void onSuccess(Object object);
    void onError(Throwable e);
}
