package com.veken.rxjavaretrofitdemo.net;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.veken.rxjavaretrofitdemo.R;
import com.veken.rxjavaretrofitdemo.module.bean.BaseRespond;
import com.veken.rxjavaretrofitdemo.net.progress.ProgressCancelListener;
import com.veken.rxjavaretrofitdemo.net.progress.ProgressDialogHandler;
import com.veken.rxjavaretrofitdemo.utils.LogUtils;
import com.veken.rxjavaretrofitdemo.utils.ToastUtils;

import org.json.JSONException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @author Veken
 */
public abstract class DefaultObserver<T extends BaseRespond> implements Observer<T>,ProgressCancelListener {
    private Context context;
    private boolean isAddInStop = false;
    private ProgressDialogHandler mProgressDialogHandler;
    //取消订阅
    private Disposable mDisposable;

    public DefaultObserver(Context context, boolean isShowLoading) {
        this.context = context;
        mProgressDialogHandler = new ProgressDialogHandler(context,this,true);
        if (isShowLoading) {
            showProgressDialog();
        }
    }

    private void showProgressDialog(){
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog(){
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable =d;
    }

    @Override
    public void onNext(T response) {
        dismissProgressDialog();
        if (response.getResCode().equals("200")) {
            onSuccess(response);
        } else {
            onFail(response);
        }
    }


    @Override
    public void onError(Throwable e) {
        LogUtils.e("Retrofit", e.getMessage());
//        dismissProgress();
        dismissProgressDialog();
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(ExceptionReason.PARSE_ERROR);
        } else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    abstract public void onSuccess(T response);


    /**
     * 服务器返回数据，但响应码不为200
     *
     * @param response 服务器返回的数据
     */
    public void onFail(T response) {
        String message = response.getResDesc();
        if (TextUtils.isEmpty(message)) {
            ToastUtils.show(R.string.response_return_error);
        } else {
            ToastUtils.show(message);
        }
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.show(R.string.connect_error, Toast.LENGTH_SHORT);
                break;

            case CONNECT_TIMEOUT:
                ToastUtils.show(R.string.connect_timeout, Toast.LENGTH_SHORT);
                break;

            case BAD_NETWORK:
                ToastUtils.show(R.string.bad_network, Toast.LENGTH_SHORT);
                break;

            case PARSE_ERROR:
                ToastUtils.show(R.string.parse_error, Toast.LENGTH_SHORT);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtils.show(R.string.unknown_error, Toast.LENGTH_SHORT);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
