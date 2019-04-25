package com.example.myframe.welcome.presenter;

import android.content.Context;

import com.example.myframe.http.base.BaseObserverNoEntry;
import com.example.myframe.http.utils.MainUtil;
import com.example.myframe.http.utils.RetrofitUtil;
import com.example.myframe.welcome.bean.CityList;
import com.example.myframe.welcome.bean.LineList;
import com.example.myframe.welcome.bean.StationList;
import com.example.myframe.welcome.module.WelcomeContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class WelcomePresenter implements WelcomeContract.presenter {

    private Context context;
    private WelcomeContract.View view;

    public WelcomePresenter(Context context, WelcomeContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 获取城市列表
     */
    @Override
    public void getCitysList() {
        RetrofitUtil.getInstance().initRetrofit().getCityList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<List<CityList>>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(List<CityList> t) throws Exception {
                        view.setCitysList(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCitysListMessage("失败了----->" + e.getMessage());
                    }
                });
    }

    /**
     * 获取线路列表
     */
    @Override
    public void getLineList() {
        RetrofitUtil.getInstance().initRetrofitMain().getLineList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LineList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(LineList t) throws Exception {
                        view.setLineList(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCitysListMessage("失败了----->" + e.getMessage());
                    }
                });
    }

    /**
     * 获取车站列表
     */
    @Override
    public void getStationList() {
        RetrofitUtil.getInstance().initRetrofitMain().getStationList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<StationList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(StationList t) throws Exception {
                        view.setStationList(t);
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCitysListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
