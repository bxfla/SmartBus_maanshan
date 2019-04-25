package com.example.myframe.bus.presenter;

import android.content.Context;

import com.example.myframe.bus.bean.LineBean;
import com.example.myframe.bus.module.LineContract;
import com.example.myframe.http.base.BaseObserverNoEntry;
import com.example.myframe.http.utils.MainUtil;
import com.example.myframe.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class LinePresenter implements LineContract.presenter {

    private Context context;
    private LineContract.View view;

    public LinePresenter(Context context, LineContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLineBean(String code) {
//        Map<String, String> map = new HashMap<>();
//        map.put("lineCode", code);
        RetrofitUtil.getInstance().initRetrofitMain().getLineBean(code).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LineBean>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(LineBean t) throws Exception {
                        view.setLineBean(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLineBeanMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
