package com.example.myframe.main.presenter;

import android.content.Context;

import com.example.myframe.http.base.BaseObserverNoEntry;
import com.example.myframe.http.utils.MainUtil;
import com.example.myframe.http.utils.RetrofitUtil;
import com.example.myframe.main.bean.Banner;
import com.example.myframe.main.module.BannerContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class BannerPresenter implements BannerContract.presenter {

    private Context context;
    private BannerContract.View view;

    public BannerPresenter(Context context, BannerContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getBanner() {
        RetrofitUtil.getInstance().initRetrofitMain().getBanner().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Banner>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Banner t) throws Exception {
                        view.setBanner(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setBannerMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
