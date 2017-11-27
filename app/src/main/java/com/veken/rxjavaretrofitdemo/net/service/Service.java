package com.veken.rxjavaretrofitdemo.net.service;


import com.veken.rxjavaretrofitdemo.common.Constants;
import com.veken.rxjavaretrofitdemo.module.bean.LoginRespond;
import com.veken.rxjavaretrofitdemo.net.request.UserInfoRequest;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * @author Veken
 */
public interface Service {


    /**
     * 登录的service
     * @param fields
     * @return
     */
    @FormUrlEncoded
    @POST(Constants.URLEND)
    Observable<LoginRespond> login(@FieldMap Map<String, Object> fields);

}
