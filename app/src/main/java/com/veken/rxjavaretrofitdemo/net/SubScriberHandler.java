package com.veken.rxjavaretrofitdemo.net;

import android.text.TextUtils;


import com.veken.rxjavaretrofitdemo.common.Constants;
import com.veken.rxjavaretrofitdemo.utils.SHA1;
import com.veken.rxjavaretrofitdemo.utils.SpConfig;

import java.security.DigestException;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Veken
 * @date on 2017/11/15 18:01
 * @describe
 */

public class SubScriberHandler {

    /**
     * @param o
     * @param <T>
     */
    public <T> void toSubscribe(Observable<T> o, DefaultObserver observer) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 添加共同参数 SHA1加密
     * @param fields
     */
    public void handleFields(Map<String, Object> fields) {
        fields.put("appKey", "00001");
        fields.put("v", "1.0");
        String sessionId = SpConfig.getInstance().getString(Constants.SESSIONID_STRING);
        if(!TextUtils.isEmpty(sessionId))
            fields.put(Constants.SESSIONID_STRING, sessionId);

        String sha1 = null;
        try {
            sha1 = SHA1.SHA1(fields);
        } catch (DigestException e) {
            e.printStackTrace();
        }
        fields.put("sign", sha1);
    }
}
