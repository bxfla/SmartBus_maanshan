package com.example.myframe.main.module;

import com.example.myframe.http.base.BaseDView;
import com.example.myframe.http.base.BasePresenter;
import com.example.myframe.main.bean.Banner;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface BannerContract {
    interface View extends BaseDView<presenter> {
        //设置banner
        void setBanner(Banner banner);
        void setBannerMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getBanner();
    }
}
