package com.example.myframe.http.base;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.example.myframe.http.dialog.ProgressHUD;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description: 自定义Observer
 */

public abstract class BaseObserverNoEntry<T> implements Observer<T> {
    protected Context mContext;
    private KProgressHUD progressHUD;
    private String labelTxt;

    public BaseObserverNoEntry(Context cxt, String text) {
        this.mContext = cxt;
        this.labelTxt = text;
        progressHUD = ProgressHUD.show(mContext);
    }

    //开始
    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    //获取数据
    @Override
    public void onNext(T tBaseEntity) {
        try {
            onSuccees(tBaseEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //失败
    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);  //网络错误
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    //结束
    @Override
    public void onComplete() {
        onRequestEnd();//请求结束
    }

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    protected abstract void onSuccees(T t) throws Exception;


    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    protected void onRequestStart() {
        if (progressHUD != null) {
            progressHUD.setLabel(labelTxt);
        }
    }

    protected void onRequestEnd() {
        if (progressHUD != null) {
            progressHUD.dismiss();
            progressHUD = null;
        }
    }

}
